package edu.uade.backend.app.messages;

import edu.uade.backend.app.externalApis.externalEjercicios.IEjercicioProvider;
import edu.uade.backend.app.events.EjercicioProvider;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

public class MessageHandEjercicioProvider implements IMessage {
    IEjercicioProvider provider;

    public MessageHandEjercicioProvider(IEjercicioProvider provider) {
        this.provider = provider;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return EjercicioProvider.RESPONSE;
    }

    public IEjercicioProvider getProvider() {
        return provider;
    }
}
