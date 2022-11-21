package edu.uade.frontend.app.states;

import edu.uade.shared.app.events.Login;
import edu.uade.shared.app.messages.MessageLoginFailed;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.frontend.app.views.ViewLogin;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.base.messaging.MessageHandler;

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
