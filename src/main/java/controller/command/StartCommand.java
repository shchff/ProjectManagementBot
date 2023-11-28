package controller.command;

import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Комманда запуска бота
 */
public class StartCommand extends Command{
    /**
     * @param command
     * @param argsList
     */
    public StartCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    @Override
    public Response perform() {
        return new Response(Facade.getStartMessage(), new ArrayList<String>(Collections.singletonList(requestUserId)));
    }
}
