package edu.uade.frontend.base.estados;

import edu.uade.compartido.utils.EnumGymPal;

public interface IState {
    void addTransition(EnumGymPal<Integer> eventId, IState transitionToState);
    IState getTransition(EnumGymPal<Integer> eventId);
    void run();
}
