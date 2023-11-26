package controller.command;

import model.project.Project;
import controller.Facade;
import view.response.Response;

import java.util.ArrayList;

/**
 * Комманда создания проекта
 */
public class CreateProjectCommand extends Command {

    public CreateProjectCommand(Commands command, ArrayList<String> argsList) {
        super(command, argsList);
    }

    @Override
    public Response perform() {
        Project project = new Project(getArgsList().get(0), getArgsList().get(1), getArgsList().get(2));
        return Facade.createProject(project);
    }
}
