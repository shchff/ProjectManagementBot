package controller.command;

import model.Facade;
import response.Response;

import java.util.ArrayList;

/**
 * Коммада завершения работы бота
 */
public class ExitCommand extends Command{
    /**
     * Конструктор класса
     * @param command
     * @param argsList
     */
    public ExitCommand(Commands command, ArrayList<String> argsList) {
        super(command, argsList);
    }

    @Override
    public Response perform() {
        return Facade.exitBot();
    }

    @Override
    public Commands getCommand() {
        return super.getCommand();
    }

    @Override
    public ArrayList<String> getArgsList() {
        return super.getArgsList();
    }
}
