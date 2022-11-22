package edu.uade.backend.app.model.strategies;

import edu.uade.backend.app.model.Ejercicio;
import edu.uade.backend.app.model.EntrenamientoDia;
import edu.uade.backend.app.model.enums.GrupoMuscular;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class BajarEntrenamientoStrategy implements IEntrenamientoStrategy {
    @Override
    public List<EntrenamientoDia> getEntrenamientos(List<DayOfWeek> diasDeSemana, List<Ejercicio> ejercicios) {
        List<EntrenamientoDia> entrenamientos = new ArrayList<>();
        for (int i = CANT_SEMANAS; i > 0; i--) {
            for(DayOfWeek day : diasDeSemana) {
                EntrenamientoDia entrenamientoDia = new EntrenamientoDia();
                entrenamientoDia.setDia(day);
                for(GrupoMuscular grupo : GrupoMuscular.values()){

                }


                entrenamientos.add(entrenamientoDia);
            }
        }

        return null;
    }
}
