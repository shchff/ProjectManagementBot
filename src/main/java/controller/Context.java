package controller;

import controller.command.Commands;

import java.util.ArrayList;

/**
 * Контекс контроллера:
 * state - состояние (EXECUTING/LISTENING)
 * command - выполняемая команда
 * iteration - итерация (какой параметр для комманды ожижается от пользователя)
 * args - параметры, заполненые пользователем
 */
public class Context {
    public State state;
    public Commands command;
    public int iteration;
    public ArrayList<String> args;
    public Context(State state, Commands command, int iteration, ArrayList<String> args) {
        this.state = state;
        this.command = command;
        this.iteration = iteration;
        this.args = args;
    }

    /**
     * перевод контекста к ожиданию команды от пользователя
     */
    public void resetContextToListening(){
        state = State.LISTENING;
        resetContext();
    }

    /**
     * "обнуление" атрибутов
     */
    private void resetContext() {
        command = Commands.NULL;
        iteration = 0;
        args.clear();
    }
    /**
     * перевод контекста к началу выполнения команды
     */
    public void startExecutingCommand(Commands command) {
        this.state = State.EXECUTING;
        this.command = command;
        this.iteration = 0;
        args.clear();
    }

    /**
     * Инкремент итератора
     */
    public void incrementIterator() {
        iteration += 1;
    }
}
