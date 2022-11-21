package edu.uade.frontend.app.states;

import edu.uade.frontend.app.views.ViewFillSocioInfo;
import edu.uade.frontend.base.states.State;
import edu.uade.shared.base.messaging.MessageBus;

public class StateFillSocioInfo extends State {
    ViewFillSocioInfo view;

    public StateFillSocioInfo(MessageBus messageBus) {
        super(messageBus);

        view = new ViewFillSocioInfo(getMessageBus());
    }

    @Override
    public void run() {
        view.show();
    }
}
