package controller;

import controller.command.Commands;
import model.Facade;

import java.util.ArrayList;

/**
 * Контекс контроллера:
 * state - состояние (EXECUTING/LISTENING)
 * command - выполняемая команда
 * iteration - итерация (какой параметр для комманды ожижается от пользователя)
 * args - аргументы, заполненые пользователем
 * params - параметры выполняемой команды
 */
public class Context {
    public State state;
    public Commands command;
    public int iteration;
    public ArrayList<String> params;
    public ArrayList<String> args;
    public Context(State state, Commands command, int iteration, ArrayList<String> args, ArrayList<String> params) {
        this.state = state;
        this.command = command;
        this.iteration = iteration;
        this.args = args;
        this.params = params;
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
        params.clear();
    }
    /**
     * перевод контекста к началу выполнения команды
     * параметры подтягиваются из компонента module
     */
    public void startExecutingCommand(Commands command) {
        this.state = State.EXECUTING;
        this.command = command;
        this.iteration = 0;
        args.clear();
        params = Facade.getParamsByCommand(command);
    }

    /**
     * Инкремент итератора
     */
    public void incrementIterator() {
        iteration += 1;
    }
}
