package edu.uade.gympal.backend.model.strategies;

import edu.uade.gympal.backend.model.Ejercicio;
import edu.uade.gympal.backend.model.EntrenamientoDia;

import java.time.DayOfWeek;
import java.util.List;

public interface IEntrenamientoStrategy {
    int CANT_SEMANAS = 4;
    public abstract List<EntrenamientoDia> getEntrenamientos(List<DayOfWeek> diasDeSemana, List<Ejercicio> ejercicios);

}
