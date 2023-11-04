package controller.command;

import response.Response;

import java.util.List;

public class CreateProjectCommand extends Command{
    public CreateProjectCommand(String command, List<String> argsList) {
        super(command, argsList);
    }

    @Override
    public Response perform() {
        return null;
    }

    @Override
    public List<String> getArgsList() {
        return super.getArgsList();
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }


}
