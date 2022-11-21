package edu.uade.frontend.base.states;

import edu.uade.shared.base.utils.EnumGymPal;

public interface IState {
    void addTransition(EnumGymPal<Integer> eventId, IState transitionToState);
    IState getTransition(EnumGymPal<Integer> eventId);
    void run();
}
