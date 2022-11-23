package edu.uade.gympal.shared.messages;

import edu.uade.gympal.backend.model.dto.SocioDto;
import edu.uade.gympal.shared.events.Register;
import edu.uade.gympal.shared.base.messaging.IMessage;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

import java.time.DayOfWeek;
import java.util.HashSet;

public class MessageCreateSocio implements IMessage {
    SocioDto socio;
    HashSet<DayOfWeek> trainingDays;

    public MessageCreateSocio(SocioDto socio, HashSet<DayOfWeek> trainingDays) {
        this.socio = socio;
        this.trainingDays = trainingDays;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return Register.CREATE_SOCIO;
    }

    public SocioDto getSocio() {
        return socio;
    }

    public HashSet<DayOfWeek> getTrainingDays() {
        return trainingDays;
    }
}
