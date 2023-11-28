package controller.command;

import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Команда завершения работы бота
 */
public class ExitCommand extends Command{
    public ExitCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    @Override
    public Response perform() {
        return new Response(Facade.exitBot(), new ArrayList<>(Collections.singletonList(requestUserId)));
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
