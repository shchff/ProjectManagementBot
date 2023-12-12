package controller.command;

import view.response.Response;

import java.util.ArrayList;

public class DeleteProjectCommand extends Command{
    public DeleteProjectCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    /**
     * @return
     */
    @Override
    public Response perform() {
        return null;
    }
}
