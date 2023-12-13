package controller.command;

import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Команда удаления проекта
 */
public class DeleteProjectCommand extends Command{
    public DeleteProjectCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    @Override
    public Response perform() {
        return new Response(Facade.deleteProject(requestUserId), new ArrayList<>(Collections.singletonList(requestUserId)));
    }
}
