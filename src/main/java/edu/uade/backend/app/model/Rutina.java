package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dto.RutinaDto;
import java.time.DayOfWeek;
import java.util.*;

public class Rutina {
    private HashMap<DayOfWeek, List<InstanciaEjercicio>> semanaEntrenamiento;

    public HashMap<DayOfWeek, List<InstanciaEjercicio>> getSemanaEntrenamiento() {
        return semanaEntrenamiento;
    }

    public void setSemanaEntrenamiento(HashMap<DayOfWeek, List<InstanciaEjercicio>> semanaEntrenamiento) {
        this.semanaEntrenamiento = semanaEntrenamiento;
    }

    public RutinaDto toDto() {
        RutinaDto dto = new RutinaDto();
        return dto;


        // Iterator
//        HashMap<DayOfWeek, List<InstanciaEjercicio>> entrenamientosDtoMap;
//
//
//        // Iterating every set of entry in the HashMap
//        for (Map.Entry<DayOfWeek, List<InstanciaEjercicio>> currentEntrenamiento : getSemanaEntrenamiento().entrySet()) {
//            List<InstanciaEjercicioDto> ejerciciosDtoList = new ArrayList<>();
//            for(InstanciaEjercicio ejercicio : currentEntrenamiento.getValue()) {
//                ejerciciosDtoList.add(ejercicio.toDto());
//            }
//            en
//
//            System.out.println(currentEntrenamiento.getKey() + " = "
//                    + currentEntrenamiento.getValue());
//        }
    }


}
