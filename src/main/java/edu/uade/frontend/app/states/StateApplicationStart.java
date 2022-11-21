package edu.uade.frontend.app.states;

import edu.uade.shared.messaging.MessageBus;
import edu.uade.frontend.app.views.ViewMainMenu;
import edu.uade.frontend.base.states.State;

public class StateApplicationStart extends State {
    public StateApplicationStart(MessageBus messageBus) {
        super(messageBus);
    }

    @Override
    public void run() {
        ViewMainMenu view = new ViewMainMenu(getMessageBus());
        view.show();
    }
}
