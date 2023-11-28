package controller;

import controller.command.Commands;

import java.util.ArrayList;

/**
 * Контекст контроллера:
 * state - состояние (EXECUTING/LISTENING)
 * command - выполняемая команда
 * iteration - итерация (какой параметр для команды ожидается от пользователя)
 * args - аргументы, заполненные пользователем
 * params - параметры выполняемой команды
 */
public class Context {

    private State state;
    private Commands command;
    private int iteration;

    private ArrayList<Params> params;

    private final ArrayList<String> args;
    public Context(State state, Commands command, int iteration, ArrayList<String> args, ArrayList<Params> params) {
        this.state = state;
        this.command = command;
        this.iteration = iteration;
        this.args = args;
        this.params = params;
    }

    /**
     * Добавление аргумента
     */

    public void addArg(String arg) {
        args.add(arg);
    }

    /**
     * Перевод контекста к ожиданию команды от пользователя
     */
    public void resetContextToListening(){
        state = State.LISTENING;
        resetContext();
    }

    /**
     * "Обнуление" атрибутов
     */
    private void resetContext() {
        command = Commands.NULL;
        iteration = 0;
        args.clear();
        params.clear();
    }
    /**
     * Перевод контекста к началу выполнения команды
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

    public Commands getCommand() {
        return command;
    }

    public int getIteration() {
        return iteration;
    }
    public ArrayList<Params> getParams() {
        return params;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public State getState() {
        return state;
    }
}
