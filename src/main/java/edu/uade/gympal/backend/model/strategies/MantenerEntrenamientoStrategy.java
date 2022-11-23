package edu.uade.gympal.backend.model.strategies;

import edu.uade.gympal.backend.model.Ejercicio;
import edu.uade.gympal.backend.model.enums.ExigenciaMuscular;

public class MantenerEntrenamientoStrategy extends EntrenamientoStrategy {

    private static final int MINUTO_MIN = 45;
    private static final int MINUTO_MAX = 80;

    public MantenerEntrenamientoStrategy() {
        super((Ejercicio ejercicio) ->
                ejercicio.getNivelAerobicoValue() >= 2
                        && ejercicio.getNivelAerobicoValue() <= 4
                        && (ejercicio.getExigenciaMuscular() == ExigenciaMuscular.MEDIA
                        || ejercicio.getExigenciaMuscular() == ExigenciaMuscular.BAJA), MINUTO_MIN, MINUTO_MAX);
    }

}
