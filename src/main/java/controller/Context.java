package controller;

import controller.command.Commands;

public class Context {
    public State state;
    public Commands command;
    public int iteration;
    public Context(State state, Commands command, int iteration) {
        this.state = state;
        this.command = command;
        this.iteration = iteration;
    }

    public void resetContextToListening(){
        this.state = State.LISTENING;
        resetContext();
    }
    private void resetContext() {
        this.command = Commands.NULL;
        this.iteration = 0;
    }
    public void startExecutingCommand(Commands command) {
        this.state = State.EXECUTING;
        this.command = command;
        this.iteration = 0;
    }
}
