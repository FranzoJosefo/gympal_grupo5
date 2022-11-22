package edu.uade.frontend.app.states;

import edu.uade.frontend.app.views.ViewDashboard;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.base.messaging.MessageBus;

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
