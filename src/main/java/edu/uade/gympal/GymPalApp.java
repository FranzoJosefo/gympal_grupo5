package edu.uade.gympal;

import edu.uade.gympal.backend.components.BackendComponent;
import edu.uade.gympal.frontend.components.Frontend;
import edu.uade.gympal.frontend.messages.MessageEvent;
import edu.uade.gympal.shared.events.General;
import edu.uade.gympal.shared.base.components.ComponentBase;
import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.messaging.MessageHandler;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class GymPalApp extends ComponentBase {
    boolean running = true;

    public GymPalApp() {
        super(new EnumGymPal<Integer>(-1), new MessageBus());

        addComponent(new BackendComponent(getMessageBus()));
        addComponent(new Frontend(getMessageBus()));

        getMessageBus().subscribe(General.EVENT, new MessageHandler<>((MessageEvent message) -> {
            if (message.getEventId() == General.APPLICATION_EXITING) {
                running = false;
            }
        }));
    }

    @Override
    public void run() {
        while (running) {
            super.run();
        }
    }
}
