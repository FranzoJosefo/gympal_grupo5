package edu.uade.gympal.frontend.base.states;

public interface IStateMachine {
    void registerState(IState state);
    void run();
}
