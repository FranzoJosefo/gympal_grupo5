package edu.uade.gympal.frontend.states;

import edu.uade.gympal.frontend.views.ViewDashboard;
import edu.uade.gympal.frontend.base.states.State;
import edu.uade.gympal.shared.base.messaging.MessageBus;

public class StateDashboard extends State {
    ViewDashboard view;
    public StateDashboard(MessageBus messageBus) {
        super(messageBus);

        view = new ViewDashboard(getMessageBus());
    }

    @Override
    public void run() {
        view.show();
    }
}
