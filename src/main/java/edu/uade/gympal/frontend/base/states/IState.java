package edu.uade.gympal.frontend.base.states;

import edu.uade.gympal.shared.base.utils.EnumGymPal;

public interface IState {
    void addTransition(EnumGymPal<Integer> eventId, IState transitionToState);
    IState getTransition(EnumGymPal<Integer> eventId);
    void run();
}
