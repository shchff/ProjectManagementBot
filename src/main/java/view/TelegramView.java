package view;

import controller.CLIController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramView implements View {
    /**
     *
     */
    private final CLIController controller;

    public TelegramView(CLIController controller) {
        this.controller = controller;
    }

    @Override
    public void startDialog() {
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot(controller));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
