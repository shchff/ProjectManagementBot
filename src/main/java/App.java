
import controller.CLIController;
import view.TelegramView;

public class App {
    public static void main(String[] args) {
        CLIController controller = new CLIController();
//        CLIView cliView = new CLIView(controller);
//        cliView.startDialog();
        TelegramView telegramView = new TelegramView(controller);
        telegramView.startDialog();
    }
}
