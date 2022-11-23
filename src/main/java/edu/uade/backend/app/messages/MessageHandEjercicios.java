package edu.uade.backend.app.messages;

import edu.uade.backend.app.model.dto.EjercicioDto;
import edu.uade.shared.base.messaging.IMessage;
import edu.uade.shared.base.utils.EnumGymPal;

import java.util.List;

public class MessageHandEjercicios implements IMessage {
    List<EjercicioDto> ejerciciosResponse;

    public MessageHandEjercicios(List<EjercicioDto> ejerciciosResponse) {
        this.ejerciciosResponse = ejerciciosResponse;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return edu.uade.backend.app.events.Ejercicio.RESPONSE;
    }

    public List<EjercicioDto> getEjercicios() {
        return ejerciciosResponse;
    }
}
