package edu.uade.gympal.frontend.states;

import edu.uade.gympal.shared.events.Login;
import edu.uade.gympal.shared.messages.MessageLoginFailed;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.frontend.views.ViewLogin;
import edu.uade.gympal.frontend.base.states.State;
import edu.uade.gympal.shared.base.messaging.MessageHandler;

public class StateLogin extends State {
    boolean loginFailed = false;
    ViewLogin view;

    public StateLogin(MessageBus messageBus) {
        super(messageBus);

        getMessageBus().subscribe(Login.FAILED, new MessageHandler<>((MessageLoginFailed message) -> {
            loginFailed = true;
        }));
        view = new ViewLogin(getMessageBus());
    }

    @Override
    public void run() {
        if (loginFailed) {
            view.setErrorMessage("Usuario y/o contraseña incorrectos");
            loginFailed = false;
        }
        view.show();
    }
}
