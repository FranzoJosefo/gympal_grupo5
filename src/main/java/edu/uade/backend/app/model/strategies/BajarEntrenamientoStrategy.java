package edu.uade.backend.app.model.strategies;

import edu.uade.backend.app.model.Ejercicio;
import edu.uade.backend.app.model.EntrenamientoDia;
import edu.uade.backend.app.model.InstanciaEjercicio;
import edu.uade.backend.app.model.enums.GrupoMuscular;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BajarEntrenamientoStrategy extends EntrenamientoStrategy {
    private static final int MINUTO_MIN = 60;
    private static final int MINUTO_MAX = 90;

    public BajarEntrenamientoStrategy() {
        super((Ejercicio ejercicio) -> ejercicio.getNivelAerobicoValue() >= 3, MINUTO_MIN, MINUTO_MAX);
    }

}
