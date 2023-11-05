
import controller.CLIController;
import controller.State;
import view.CLIView;

public class App {
    public static void main(String[] args) {
        CLIController controller = new CLIController(State.LISTENING);
        CLIView cliView = new CLIView(controller);
        cliView.startDialog();
    }
}
