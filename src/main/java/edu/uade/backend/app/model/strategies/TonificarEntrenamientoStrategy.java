package edu.uade.backend.app.model.strategies;

import edu.uade.backend.app.model.Ejercicio;
import edu.uade.backend.app.model.EntrenamientoDia;
import edu.uade.backend.app.model.enums.ExigenciaMuscular;

import java.time.DayOfWeek;
import java.util.List;

public class TonificarEntrenamientoStrategy extends EntrenamientoStrategy {

    private static final int MINUTO_MIN = 120;
    private static final int MINUTO_MAX = 150;

    public TonificarEntrenamientoStrategy() {
        super((Ejercicio ejercicio) -> ejercicio.getNivelAerobicoValue() <= 4 && ejercicio.getExigenciaMuscular() == ExigenciaMuscular.ALTA, MINUTO_MIN, MINUTO_MAX);
    }

}
