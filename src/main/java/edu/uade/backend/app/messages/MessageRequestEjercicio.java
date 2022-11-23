package edu.uade.backend.app.messages;

import edu.uade.backend.app.events.Ejercicio;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageRequestEjercicio implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Ejercicio.REQUEST;
    }
}
