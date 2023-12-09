package controller.command;

import model.Project;
import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Команда создания проекта
 */
public class CreateProjectCommand extends Command {

    public CreateProjectCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    @Override
    public Response perform() {
        Project project = new Project(getArgsList().get(0), getArgsList().get(1), getArgsList().get(2));
        return new Response(Facade.createProject(project), new ArrayList<>(Collections.singletonList(requestUserId)));
    }
}
