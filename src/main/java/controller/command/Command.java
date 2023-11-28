package controller.command;

import view.response.Response;

import java.util.ArrayList;

/**
 * Команда для выполнения контроллером
 * command - исполняемая команда
 * argsList - аргументы команды
 * requestUserId - id человека, который запустил команду
 */

public abstract class Command {
    private final Commands command;
    private final ArrayList<String> argsList;

    protected final String requestUserId;

    public Command(Commands command, ArrayList<String> argsList, String requestUserId) {
        this.command = command;
        this.argsList = argsList;
        this.requestUserId = requestUserId;
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
