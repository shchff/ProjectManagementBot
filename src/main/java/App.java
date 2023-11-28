
import controller.Controller;
import view.TelegramView;

public class App {
    // Задача 3
    public static void main(String[] args) {
        Controller controller = new Controller();
        TelegramView telegramView = new TelegramView(controller);
        telegramView.startDialog();
    }
}
