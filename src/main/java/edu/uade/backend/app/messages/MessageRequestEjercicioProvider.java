package edu.uade.backend.app.messages;

import edu.uade.backend.app.events.EjercicioProvider;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageRequestEjercicioProvider implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return EjercicioProvider.REQUEST;
    }
}
