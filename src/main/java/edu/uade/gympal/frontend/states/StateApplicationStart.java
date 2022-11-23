package edu.uade.gympal.frontend.states;

import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.frontend.views.ViewMainMenu;
import edu.uade.gympal.frontend.base.states.State;

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
