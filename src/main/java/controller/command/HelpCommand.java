package controller.command;

import controller.Facade;
import view.response.Response;

import java.util.ArrayList;

/**
 * Комманда вывода информации о боте
 */
public class HelpCommand extends Command{
    /**
     * @param command
     * @param argsList
     */
    public HelpCommand(Commands command, ArrayList<String> argsList) {
        super(command, argsList);
    }

    @Override
    public Response perform() {
        return Facade.getHelp();
    }
}
