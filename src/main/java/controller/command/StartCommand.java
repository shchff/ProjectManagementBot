package controller.command;

import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
/**
 * Комманда запуска бота
 */
public class StartCommand extends Command{
    /**
     * @param command
     * @param argsList
     */
    public StartCommand(Commands command, ArrayList<String> argsList) {
        super(command, argsList);
    }

    @Override
    public Response perform() {

        return Facade.getStartMessage();
    }
}
