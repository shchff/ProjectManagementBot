package controller.command;

import response.Response;

import java.util.ArrayList;


public abstract class Command {
    private Commands command;
    private ArrayList<String> argsList;

    public Command(Commands command, ArrayList<String> argsList) {
        this.command = command;
        this.argsList = argsList;
    }

    public abstract Response perform();

    public Commands getCommand() {
        return command;
    }

    public ArrayList<String> getArgsList() {
        return argsList;
    }

}
