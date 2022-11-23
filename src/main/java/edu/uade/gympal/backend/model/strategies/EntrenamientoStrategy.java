package edu.uade.gympal.backend.model.strategies;

import edu.uade.gympal.backend.model.Ejercicio;
import edu.uade.gympal.backend.model.EntrenamientoDia;
import edu.uade.gympal.backend.model.InstanciaEjercicio;
import edu.uade.gympal.backend.model.enums.GrupoMuscular;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EntrenamientoStrategy implements IEntrenamientoStrategy {

    IEjercicioFilterPredicate filterPredicate;
    int minutoMax;
    int minutoMin;

    public EntrenamientoStrategy(IEjercicioFilterPredicate filterPredicate, int minutoMin, int minutoMax) {
        this.filterPredicate = filterPredicate;
        this.minutoMin = minutoMin;
        this.minutoMax = minutoMax;
    }

    @Override
    public List<EntrenamientoDia> getEntrenamientos(List<DayOfWeek> diasDeSemanaElegidos, List<Ejercicio> ejercicios) {
        List<EntrenamientoDia> entrenamientos = new ArrayList<>();
        // Primero me quedo solo con los ejercicios que cumlpen con las reglas de Bajar de Peso.
        ejercicios = getEjerciciosByPredicate(ejercicios, filterPredicate);

        // Despues me aseguro de tener suficientes para 4 semanas (no importa si los repito)
        for (int i = CANT_SEMANAS; i > 0; i--) { //Nivel Rutina - 4 Semanas
            // Unicamente agrego los dias que el usuario eligio.
            for (DayOfWeek day : diasDeSemanaElegidos) {
                List<InstanciaEjercicio> ejerciciosInstanciados = new ArrayList<>();
                int currentEjercicioIndex = addEjercicioRandom(ejercicios, ejerciciosInstanciados, minutoMin, 0);
                addEjercicioRandom(ejercicios, ejerciciosInstanciados, minutoMax + 1, currentEjercicioIndex);

                EntrenamientoDia entrenamientoDia = new EntrenamientoDia();
                entrenamientoDia.setDia(day);
                entrenamientoDia.setEjerciciosDelDia(ejerciciosInstanciados);
                entrenamientos.add(entrenamientoDia);
            }
        }

        return entrenamientos;
    }

    /**
     * Aca usamos AtomicReference porque: Si uso variable dentro de las lambda en Java y esta definida dentro del scope de un metodo
     * y no de la instancia. Java me olbiga a asegurarme que esa variable siga viviendo mientras necesite ser usada.
     * Porque si llegara a usarlo en un contexto Async, Java no tendria manera de asegurarse de que sea ese el caso.
     */

    private int addEjercicioRandom(List<Ejercicio> ejercicios, List<InstanciaEjercicio> ejerciciosInstanciados, int bound, int searchStartIndex) {
        int minutosAcumulados = 0;
        for (InstanciaEjercicio ejercicio : ejerciciosInstanciados) {
            minutosAcumulados += ejercicio.getEjercicio().getTiempoTotalEjercicio();
        }

        while (minutosAcumulados < bound && searchStartIndex < ejercicios.size()) {
            for (GrupoMuscular grupo : GrupoMuscular.values()) {
                AtomicReference<GrupoMuscular> grupoMuscular = new AtomicReference<>(grupo);
                List<Ejercicio> shuffledList = getEjerciciosByPredicate(ejercicios, (Ejercicio ejercicio) -> ejercicio.getGrupoMuscular() == grupoMuscular.get());
                if (shuffledList.size() > 0) {
                    Collections.shuffle(shuffledList);
                    InstanciaEjercicio instanciaEjercicio = new InstanciaEjercicio();
                    instanciaEjercicio.setEjercicio(shuffledList.get(0));
                    if (!(minutosAcumulados + instanciaEjercicio.getEjercicio().getTiempoTotalEjercicio() > minutoMax)) {
                        ejerciciosInstanciados.add(instanciaEjercicio);
                    }
                    minutosAcumulados += instanciaEjercicio.getEjercicio().getTiempoTotalEjercicio();
                }
            }
            searchStartIndex++;
        }

        return searchStartIndex;
    }

    static List<Ejercicio> getEjerciciosByPredicate(List<Ejercicio> ejercicios, IEjercicioFilterPredicate predicate) {
        List<Ejercicio> newEjercicioList = new ArrayList<>();
        for (Ejercicio curEjercicio : ejercicios) {
            if (predicate.meetsCriteria(curEjercicio)) {
                newEjercicioList.add(curEjercicio);
            }
        }
        return newEjercicioList;
    }

    interface IEjercicioFilterPredicate {
        boolean meetsCriteria(Ejercicio ejercicio);
    }
}
