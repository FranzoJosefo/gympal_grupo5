package edu.uade.shared.app;

import edu.uade.backend.app.components.Backend;
import edu.uade.frontend.app.components.Frontend;
import edu.uade.frontend.app.messages.MessageEvent;
import edu.uade.shared.app.events.General;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.messaging.MessageHandler;
import edu.uade.shared.base.utils.EnumGymPal;

public class GymPalApp extends ComponentBase {
    boolean running = true;

    public GymPalApp() {
        super(new EnumGymPal<Integer>(-1), new MessageBus());

        addComponent(new Backend(getMessageBus()));
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
