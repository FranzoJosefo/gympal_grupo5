package edu.uade.frontend.app.states;

import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.frontend.app.messages.MessageLoginDetailsIntroduced;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.app.events.Login;
import edu.uade.shared.app.messages.MessageLoginFailed;
import edu.uade.shared.app.messages.MessageLoginSuccess;
import edu.uade.shared.app.messages.MessageTryLogin;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;

public class StateLoginInProgress extends State {
    MessageLoginDetailsIntroduced lastLoginDetails;

    public StateLoginInProgress(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(Login.Navigation.LOGIN_DETAILS_INTRODUCED, new MessageHandler<>((MessageLoginDetailsIntroduced message) -> {
            lastLoginDetails = message;
        }));
        getMessageBus().subscribe(Login.SUCCESS, new MessageHandler<>((MessageLoginSuccess message) -> {
            loginSuccess();
        }));
        getMessageBus().subscribe(Login.FAILED, new MessageHandler<>((MessageLoginFailed message) -> {
            loginFailed();
        }));
    }

    @Override
    public void run() {
        if (lastLoginDetails != null) {
            getMessageBus().sendMessage(new MessageTryLogin(lastLoginDetails.getUserName(), lastLoginDetails.getPassword()));
        } else {
            loginFailed();
        }
    }

    void loginSuccess() {
        getMessageBus().sendMessage(new MessageEvent(Login.SUCCESS));
    }

    void loginFailed() {
        getMessageBus().sendMessage(new MessageEvent(Login.FAILED));
    }
}
