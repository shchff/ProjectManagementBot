
import controller.CLIController;
import view.CLIView;

public class App {
    // Задача 1
    public static void main(String[] args) {
        CLIController controller = new CLIController();
        CLIView cliView = new CLIView(controller);
        cliView.startDialog();
    }
}
