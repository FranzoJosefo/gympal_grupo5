package edu.uade.frontend.base.estados;

public interface IStateMachine {
    void registerState(IState state);
    void run();
}
