package view;

import controller.CLIController;
import io.github.cdimascio.dotenv.Dotenv;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import request.Request;
import response.Response;

public class TelegramBot extends TelegramLongPollingBot {
    private final CLIController controller;

    public TelegramBot(CLIController controller) {
        this.controller = controller;
    }

    @Override
    public String getBotUsername() {
        return "ProjectManagementBot";
    }

    @Override
    public String getBotToken() {
        return Dotenv.load().get("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        User user = msg.getFrom();
        Long id = user.getId();

        Request request = new Request(msg.getText());

        Response response = controller.handleWithResponse(request);

        sendText(id, response.getResponse());
//        System.out.println(user.getFirstName() + " wrote " + msg.getText());
    }
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}