package controller.command;

import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

public class DeleteProjectCommand extends Command{
    public DeleteProjectCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    /**
     * @return
     */
    @Override
    public Response perform() {
        return new Response(Facade.deleteProject(requestUserId), new ArrayList<>(Collections.singletonList(requestUserId)));
    }
}
