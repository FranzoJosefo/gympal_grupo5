package edu.uade.gympal.frontend.components;

import edu.uade.gympal.frontend.states.StateMachineFrontend;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;

public class StateMachine extends ComponentBase {
    edu.uade.gympal.frontend.states.StateMachine stateMachine;
    public StateMachine(MessageBus messageBus) {
        super(Ids.STATE_MACHINE, messageBus);

        stateMachine = new StateMachineFrontend(messageBus);
    }

    @Override
    public void run() {
        stateMachine.run();
        super.run();
    }
}
