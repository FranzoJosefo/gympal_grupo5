package edu.uade.frontend.app.components;

import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;

public class StateMachine extends ComponentBase {
    edu.uade.frontend.app.states.StateMachine stateMachine;
    public StateMachine(MessageBus messageBus) {
        super(Ids.STATE_MACHINE, messageBus);

        stateMachine = new edu.uade.frontend.app.states.StateMachineFronted(messageBus);
    }

    @Override
    public void run() {
        stateMachine.run();
        super.run();
    }
}
