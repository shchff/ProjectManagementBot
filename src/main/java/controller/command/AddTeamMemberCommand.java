package controller.command;

import controller.Facade;
import model.Role;
import model.TeamMember;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

public class AddTeamMemberCommand extends Command{
    public AddTeamMemberCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    /**
     * @return
     */

    @Override
    public Response perform() {
        TeamMember teamMember = new TeamMember(getArgsList().get(0), new Role(getArgsList().get(1)));
        return new Response(Facade.addTeamMember(teamMember), new ArrayList<>(Collections.singletonList(requestUserId)));
    }
}
