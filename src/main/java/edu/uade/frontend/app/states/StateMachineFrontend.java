package edu.uade.frontend.app.states;

import edu.uade.frontend.app.messages.MessageLoginDetailsIntroduced;
import edu.uade.frontend.app.messages.MessageRegisterDetailsIntroduced;
import edu.uade.shared.app.events.General;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.app.events.Register;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;
import edu.uade.shared.base.utils.EnumGymPal;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.base.states.IState;

public class StateMachineFrontend extends StateMachine {
    public StateMachineFrontend(MessageBus messageBus) {
        super(messageBus);

        MessageHandler<MessageEvent> eventMessageHandler = new MessageHandler<MessageEvent>((MessageEvent message) -> {
            transition(message.getEventId());
        });
        messageBus.subscribe(General.EVENT, eventMessageHandler);
        messageBus.subscribe(edu.uade.frontend.app.events.Login.LOGIN_DETAILS_INTRODUCED, new MessageHandler<>((MessageLoginDetailsIntroduced message) -> {
            transition(message.getId());
        }));
        messageBus.subscribe(edu.uade.frontend.app.events.Register.REGISTER_DETAILS_INTRODUCED, new MessageHandler<>((MessageRegisterDetailsIntroduced message) -> {
            transition(message.getId());
        }));

        IState stateStartApp = new StateApplicationStart(messageBus);
        IState stateLogin = new StateLogin(messageBus);
        IState stateLoginInProgress = new StateLoginInProgress(messageBus);
        IState stateRegister = new StateRegister(messageBus);
        IState stateRegisterInProgress = new StateRegisterInProgress(messageBus);
        IState stateFillSocioInfo = new StateFillSocioInfo(messageBus);
        IState stateDashboard = new StateDashboard(messageBus);

        stateStartApp.addTransition(edu.uade.frontend.app.events.Login.LOGIN_DETAILS_INPUT_STARTED, stateLogin);
        stateStartApp.addTransition(edu.uade.frontend.app.events.Register.REGISTER_DETAILS_INPUT_STARTED, stateRegister);

        stateLogin.addTransition(edu.uade.frontend.app.events.Login.CANCELLED, stateStartApp);
        stateLogin.addTransition(edu.uade.frontend.app.events.Login.LOGIN_DETAILS_INTRODUCED, stateLoginInProgress);
        stateLoginInProgress.addTransition(Login.FAILED, stateLogin);
        stateLoginInProgress.addTransition(Login.SUCCESS, stateDashboard);

        // Intencional: Login.CANCELLED
        stateRegister.addTransition(edu.uade.frontend.app.events.Login.CANCELLED, stateStartApp);
        stateRegister.addTransition(edu.uade.frontend.app.events.Register.REGISTER_DETAILS_INTRODUCED, stateRegisterInProgress);
        stateRegisterInProgress.addTransition(Register.FAILED, stateRegister);
        stateRegisterInProgress.addTransition(Register.SUCCESS, stateFillSocioInfo);

        stateFillSocioInfo.addTransition(Login.SUCCESS, stateDashboard);

        registerState(stateStartApp);
        registerState(stateLogin);
        registerState(stateLoginInProgress);
        registerState(stateRegister);
        registerState(stateRegisterInProgress);
        registerState(stateFillSocioInfo);
        registerState(stateDashboard);
    }

    void transition(EnumGymPal<Integer> eventId) {
        if (currentState != null) {
            IState newState = currentState.getTransition(eventId);
            if (newState != null && validStates.contains(newState)) {
                currentState = newState;
            }
        }
    }
}
