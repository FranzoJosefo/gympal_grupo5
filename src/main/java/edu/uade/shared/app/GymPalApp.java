package edu.uade.shared.app;

import edu.uade.backend.app.components.Backend;
import edu.uade.frontend.app.components.Frontend;
import edu.uade.shared.base.components.ComponentBase;
import edu.uade.shared.base.messaging.MessageBus;
import edu.uade.shared.base.utils.EnumGymPal;

public class GymPalApp extends ComponentBase {
    public GymPalApp() {
        super(new EnumGymPal<Integer>(-1), new MessageBus());

        addComponent(new Backend(getMessageBus()));
        addComponent(new Frontend(getMessageBus()));
    }
}
