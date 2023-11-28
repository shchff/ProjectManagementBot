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

import java.util.ArrayList;

/**
 * Вид в телеграме
 */

public class TelegramView extends TelegramLongPollingBot implements View {
    private final Controller controller;

    public TelegramView(Controller controller) {
        this.controller = controller;
    }

    /**
     * Получение имени бота
     * @return string название бота
     */
    @Override
    public String getBotUsername() {
        return Dotenv.load().get("BOT_USERNAME");
    }

    /**
     * Получения токена для работы с ботом
     * @return string токен, содержащийся в .env
     */
    @Override
    public String getBotToken() {

        return Dotenv.load().get("BOT_TOKEN");
    }

    /**
     * Реакция на действия пользователя
     * @param update - действие пользователя
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message msg = update.getMessage();
            User user = msg.getFrom();
            Long id = user.getId();

            Request request = new Request(msg.getText(), id.toString());

            Response response = controller.handleWithResponse(request);

            ArrayList<String> responsers = response.getResponseUserIds();

            for (String responser : responsers) {
                sendText(responser, response.getResponse());
            }
        }
    }

    /**
     * Отправка сообщения
     * @param userId - id человека, которому отправляется сообщение
     * @param text - текст сообщения
     */
    private void sendText(String userId, String text){
        SendMessage sm = SendMessage.builder()
                .chatId(userId)
                .text(text).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * startDialog - запуск диалога в телеграме
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