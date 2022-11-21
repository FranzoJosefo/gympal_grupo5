package edu.uade.frontend.app.states;

import edu.uade.shared.messaging.MessageBus;
import edu.uade.frontend.app.views.ViewLogin;
import edu.uade.frontend.base.states.State;

public class StateLogin extends State {

    public StateLogin(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void run() {
        ViewLogin view = new ViewLogin(getMessageBus());
        view.show();
    }
}
