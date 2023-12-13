package controller.command;

import view.response.Response;

import java.util.ArrayList;

public class DeleteTeamMemberCommand extends Command
{
    public DeleteTeamMemberCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
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
