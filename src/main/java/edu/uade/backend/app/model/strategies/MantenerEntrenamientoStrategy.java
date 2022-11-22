package edu.uade.backend.app.model.strategies;

import edu.uade.backend.app.model.Ejercicio;
import edu.uade.backend.app.model.EntrenamientoDia;

import java.time.DayOfWeek;
import java.util.List;

public class MantenerEntrenamientoStrategy implements IEntrenamientoStrategy {
    @Override
    public List<EntrenamientoDia> getEntrenamientos(List<DayOfWeek> diasDeSemana, List<Ejercicio> ejercicios) {
        return null;
    }
}
