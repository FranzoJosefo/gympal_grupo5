package edu.uade.backend.app.model.strategies;

import edu.uade.backend.app.model.Ejercicio;
import edu.uade.backend.app.model.EntrenamientoDia;
import edu.uade.backend.app.model.InstanciaEjercicio;
import edu.uade.backend.app.model.enums.GrupoMuscular;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EntrenamientoStrategy implements IEntrenamientoStrategy {

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
        //Primero me quedo solo con los ejercicios que cumlpen con las reglas de Bajar de Peso.
        ejercicios = getEjerciciosByPredicate(ejercicios, filterPredicate);

        //Despues me aseguro de tener suficientes para 4 semanas (no importa si los repito)
        for (int i = CANT_SEMANAS; i > 0; i--) { //Nivel Rutina - 4 Semanas

            //Unicamente agrego los dias que el usuario eligio.
            for (DayOfWeek day : diasDeSemanaElegidos) {
                EntrenamientoDia entrenamientoDia = new EntrenamientoDia();
                entrenamientoDia.setDia(day);

                List<InstanciaEjercicio> ejerciciosInstanciados = new ArrayList<>();

                int minutosAcumulados = 0;
                int count = 0;
                while (minutosAcumulados < minutoMin && count < ejercicios.size()) {
                    minutosAcumulados += addEjercicioRandom(ejercicios, ejerciciosInstanciados);
                    count++;
                }
                while (minutosAcumulados < minutoMax + 1 && count < ejercicios.size()) {
                    minutosAcumulados += addEjercicioRandom(ejercicios, ejerciciosInstanciados);
                    count++;
                }
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

    private int addEjercicioRandom(List<Ejercicio> ejercicios, List<InstanciaEjercicio> ejerciciosInstanciados) {
        int minutosAcumulados = 0;
        for (GrupoMuscular grupo : GrupoMuscular.values()) {
            List<Ejercicio> shuffledList = getEjerciciosByGrupoMuscular(ejercicios, grupo);
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
        return minutosAcumulados;
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

    static List<Ejercicio> getEjerciciosByGrupoMuscular(List<Ejercicio> ejercicios, GrupoMuscular grupo) {
        List<Ejercicio> newEjercicioList = new ArrayList<>();
        for (Ejercicio curEjercicio : ejercicios) {
            if (curEjercicio.getGrupoMuscular() == grupo) {
                newEjercicioList.add(curEjercicio);
            }
        }
        return newEjercicioList;
    }

    interface IEjercicioFilterPredicate {
        boolean meetsCriteria(Ejercicio ejercicio);
    }
}
