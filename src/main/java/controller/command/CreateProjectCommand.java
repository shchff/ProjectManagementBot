package controller.command;

import model.project.Project;
import controller.Facade;
import view.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Комманда создания проекта
 */
public class CreateProjectCommand extends Command {

    public CreateProjectCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    @Override
    public Response perform() {
        Project project = new Project(getArgsList().get(0), getArgsList().get(1), getArgsList().get(2));
        return new Response(Facade.createProject(project), new ArrayList<String>(Collections.singletonList(requestUserId)));
    }
}
