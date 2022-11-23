package edu.uade.gympal.frontend.states;

import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.frontend.base.states.IState;
import edu.uade.gympal.frontend.base.states.IStateMachine;

import java.util.ArrayList;
import java.util.List;

public class StateMachine implements IStateMachine {
    protected List<IState> validStates = new ArrayList<>();
    IState currentState;
    MessageBus messageBus;

    public StateMachine(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    // El primer estado ingresado será considerado el inicial
    @Override
    public void registerState(IState state) {
        if (!validStates.contains(state)) {
            validStates.add(state);
            if (currentState == null) {
                currentState = state;
            }
        }
    }

    @Override
    public void run() {
        currentState.run();
    }
}
