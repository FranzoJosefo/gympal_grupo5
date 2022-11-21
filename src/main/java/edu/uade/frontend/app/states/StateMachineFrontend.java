package edu.uade.frontend.app.states;

import edu.uade.shared.app.events.Login;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;
import edu.uade.shared.base.utils.EnumGymPal;
import edu.uade.frontend.app.events.Shared;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.base.states.IState;

public class StateMachineFrontend extends StateMachine {
    public StateMachineFrontend(MessageBus messageBus) {
        super(messageBus);

        MessageHandler<MessageEvent> eventMessageHandler = new MessageHandler<MessageEvent>((MessageEvent message) -> {
            transition(message.getEventId());
        });
        messageBus.subscribe(Shared.EVENT, eventMessageHandler);

        IState stateStartApp = new StateApplicationStart(messageBus);
        IState stateLogin = new StateLogin(messageBus);
        stateStartApp.addTransition(Login.Navigation.LOGIN_DETAILS_INPUT_STARTED, stateLogin);
        stateLogin.addTransition(Login.Navigation.CANCELLED, stateStartApp);

        registerState(stateStartApp);
        registerState(stateLogin);
    }

    void transition(EnumGymPal<Integer> eventId) {
        if (currentState != null) {
            IState newState = currentState.getTransition(eventId);
            if (newState != null && validStates.contains(newState)) {
                currentState = newState;
                currentState.run();
            }
        }
    }
}
