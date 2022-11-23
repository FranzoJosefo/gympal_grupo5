package edu.uade.gympal.frontend.states;

import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.frontend.messages.MessageLoginDetailsIntroduced;
import edu.uade.gympal.frontend.base.states.State;
import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.messages.MessageLoginFailed;
import edu.uade.gympal.shared.messages.MessageLoginSuccess;
import edu.uade.gympal.shared.messages.MessageTryLogin;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class StateLoginInProgress extends State {
    MessageLoginDetailsIntroduced lastLoginDetails;

    public StateLoginInProgress(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(edu.uade.gympal.frontend.events.Login.LOGIN_DETAILS_INTRODUCED, new MessageHandler<>((MessageLoginDetailsIntroduced message) -> {
            lastLoginDetails = message;
        }));
        getMessageBus().subscribe(Login.SUCCESS, new MessageHandler<>((MessageLoginSuccess message) -> {
            getMessageBus().sendMessage(new MessageEvent(message.getId()));
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

    void loginFailed() {
        getMessageBus().sendMessage(new MessageEvent(Login.FAILED));
    }
}
