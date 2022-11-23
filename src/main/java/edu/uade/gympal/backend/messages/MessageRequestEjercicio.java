package edu.uade.gympal.backend.messages;

import edu.uade.gympal.backend.events.Ejercicio;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

public class MessageRequestEjercicio implements IMessage {
    @Override
    public EnumGymPal<Integer> getId() {
        return Ejercicio.REQUEST;
    }
}
