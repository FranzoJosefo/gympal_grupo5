package edu.uade.gympal.backend.messages;

import edu.uade.gympal.backend.model.dto.EjercicioDto;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

import java.util.List;

public class MessageHandEjercicios implements IMessage {
    List<EjercicioDto> ejerciciosResponse;

    public MessageHandEjercicios(List<EjercicioDto> ejerciciosResponse) {
        this.ejerciciosResponse = ejerciciosResponse;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return edu.uade.gympal.backend.events.Ejercicio.RESPONSE;
    }

    public List<EjercicioDto> getEjercicios() {
        return ejerciciosResponse;
    }
}
