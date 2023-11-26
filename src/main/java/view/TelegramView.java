package view;

import controller.Controller;
import io.github.cdimascio.dotenv.Dotenv;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import view.request.Request;
import view.response.Response;

public class TelegramView extends TelegramLongPollingBot implements View {
    private final Controller controller;

    public TelegramView(Controller controller) {
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

        Request request = new Request(msg.getText(), id);

        Response response = controller.handleWithResponse(request);

        sendText(id, response.getResponse());
    }
    private void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * startDialog - запуск диалога
     */
    @Override
    public void startDialog() {
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}