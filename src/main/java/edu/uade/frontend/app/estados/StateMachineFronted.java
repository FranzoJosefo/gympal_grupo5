package edu.uade.frontend.app.estados;

import edu.uade.compartido.app.eventos.Login;
import edu.uade.compartido.mensajeria.MessageBus;
import edu.uade.compartido.mensajeria.MessageHandler;
import edu.uade.compartido.utils.EnumGymPal;
import edu.uade.frontend.app.eventos.Shared;
import edu.uade.frontend.app.mensajes.MessageEvent;
import edu.uade.frontend.base.estados.IState;

public class StateMachineFronted extends StateMachine {
    public StateMachineFronted(MessageBus messageBus) {
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
