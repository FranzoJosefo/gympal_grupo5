package edu.uade.gympal.backend.model.strategies;

import edu.uade.gympal.backend.model.Ejercicio;
import edu.uade.gympal.backend.model.enums.ExigenciaMuscular;

public class TonificarEntrenamientoStrategy extends EntrenamientoStrategy {

    private static final int MINUTO_MIN = 120;
    private static final int MINUTO_MAX = 150;

    public TonificarEntrenamientoStrategy() {
        super((Ejercicio ejercicio) -> ejercicio.getNivelAerobicoValue() <= 4 && ejercicio.getExigenciaMuscular() == ExigenciaMuscular.ALTA, MINUTO_MIN, MINUTO_MAX);
    }

}
