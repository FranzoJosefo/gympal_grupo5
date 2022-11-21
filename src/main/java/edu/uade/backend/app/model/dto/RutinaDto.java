package edu.uade.backend.app.model.dto;

import edu.uade.backend.app.model.InstanciaEjercicio;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;

public class RutinaDto {
    private HashMap<DayOfWeek, List<InstanciaEjercicioDto>> entrenamientos;

    public HashMap<DayOfWeek, List<InstanciaEjercicioDto>> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(HashMap<DayOfWeek, List<InstanciaEjercicioDto>> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }
}
