package edu.uade.gympal.backend.model.strategies;

import edu.uade.gympal.backend.model.Ejercicio;

public class BajarEntrenamientoStrategy extends EntrenamientoStrategy {
    private static final int MINUTO_MIN = 60;
    private static final int MINUTO_MAX = 90;

    public BajarEntrenamientoStrategy() {
        super((Ejercicio ejercicio) -> ejercicio.getNivelAerobicoValue() >= 3, MINUTO_MIN, MINUTO_MAX);
    }

}
