package controller.command;

import view.response.Response;

import java.util.ArrayList;

/**
 * Комманда для выполнения контроллером
 */

public abstract class Command {
    private Commands command;
    private ArrayList<String> argsList;

    public Command(Commands command, ArrayList<String> argsList) {
        this.command = command;
        this.argsList = argsList;
    }

    /**
     * Выполняет комманду со списком аргументов argsList
     * @return response - резултьтат выполения команды
     */
    public abstract Response perform();

    public Commands getCommand() {
        return command;
    }

    public ArrayList<String> getArgsList() {
        return argsList;
    }

}
