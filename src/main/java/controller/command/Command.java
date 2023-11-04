package controller.command;

import response.Response;

import java.util.List;


public abstract class Command {
    private final String command;

    private final List<String> argsList;

    public Command(String command, List<String> argsList) {
        this.command = command;
        this.argsList = argsList;
    }

    public abstract Response perform();

    public String getCommand() {
        return command;
    }

    public List<String> getArgsList() {
        return argsList;
    }
}
