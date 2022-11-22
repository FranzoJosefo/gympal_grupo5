package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dto.EntrenamientoDiaDto;
import edu.uade.backend.app.model.dto.RutinaDto;
import java.time.DayOfWeek;
import java.util.*;

public class Rutina {
    List<EntrenamientoDia> entrenamientos;

    public List<EntrenamientoDia> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<EntrenamientoDia> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public RutinaDto toDto() {
        RutinaDto dto = new RutinaDto();
        List<EntrenamientoDiaDto> entrenamientosDto = new ArrayList<>();
        for (EntrenamientoDia entrenamientoDia : getEntrenamientos()) {
            entrenamientosDto.add(entrenamientoDia.toDto());
        }
        dto.setEntrenamientos(entrenamientosDto);
        return dto;
    }

}
