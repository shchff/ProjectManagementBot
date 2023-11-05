package controller;

import controller.command.Commands;

import java.util.ArrayList;

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
    public void resetContextToListening(){
        state = State.LISTENING;
        resetContext();
    }
    private void resetContext() {
        command = Commands.NULL;
        iteration = 0;
        args.clear();
    }
    public void startExecutingCommand(Commands command) {
        this.state = State.EXECUTING;
        this.command = command;
        this.iteration = 0;
        args.clear();
    }
    public void incrementIterator() {
        iteration += 1;
    }
}
