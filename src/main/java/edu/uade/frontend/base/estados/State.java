package edu.uade.frontend.base.estados;

import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.compartido.utils.EnumGymPal;

import java.util.HashMap;

public abstract class State implements IState {
    HashMap<EnumGymPal<Integer>, IState> transitions;
    MessageBus messageBus;

    public State(MessageBus messageBus) {
        transitions = new HashMap<>();
        this.messageBus = messageBus;
    }

    @Override
    public void addTransition(EnumGymPal<Integer> eventId, IState transitionToState) {
        transitions.put(eventId, transitionToState);
    }

    @Override
    public IState getTransition(EnumGymPal<Integer> eventId) {
        return transitions.getOrDefault(eventId, null);
    }

    public MessageBus getMessageBus() {
        return messageBus;
    }
}
