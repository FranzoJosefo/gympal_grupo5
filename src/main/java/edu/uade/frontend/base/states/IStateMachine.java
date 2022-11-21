package edu.uade.frontend.base.states;

public interface IStateMachine {
    void registerState(IState state);
    void run();
}
