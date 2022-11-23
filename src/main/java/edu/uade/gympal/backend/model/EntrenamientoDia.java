package edu.uade.gympal.backend.model;

import edu.uade.gympal.backend.model.dto.EntrenamientoDiaDto;
import edu.uade.gympal.backend.model.dto.InstanciaEjercicioDto;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class EntrenamientoDia {
    private List<InstanciaEjercicio> ejerciciosDelDia;
    private DayOfWeek dia;

    public List<InstanciaEjercicio> getEjerciciosDelDia() {
        return ejerciciosDelDia;
    }

    public void setEjerciciosDelDia(List<InstanciaEjercicio> ejerciciosDelDia) {
        this.ejerciciosDelDia = ejerciciosDelDia;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public EntrenamientoDiaDto toDto() {
        EntrenamientoDiaDto dto = new EntrenamientoDiaDto();
        dto.setDia(getDia());

        List<InstanciaEjercicioDto> ejerciciosDelDiaDto = new ArrayList<>();
        for (InstanciaEjercicio instanciaEjercicio : getEjerciciosDelDia()) {
            ejerciciosDelDiaDto.add(instanciaEjercicio.toDto());
        }

        dto.setEjerciciosDelDia(ejerciciosDelDiaDto);
        return dto;
    }

    public static List<EntrenamientoDiaDto> convertEntrenamientoDiaListToDto(List<EntrenamientoDia> entrenamientoDiaList) {
        List<EntrenamientoDiaDto> entrenamientoDiaDtoList = new ArrayList<>();
        for (EntrenamientoDia entrenamientoDia : entrenamientoDiaList) {
            EntrenamientoDiaDto entrenamientoDiaDto = new EntrenamientoDiaDto();
            entrenamientoDiaDto.setDia(entrenamientoDia.getDia());
            entrenamientoDiaDto.setEjerciciosDelDia(InstanciaEjercicio.convertInstanciaEjercicioListToDto(entrenamientoDia.getEjerciciosDelDia()));
            entrenamientoDiaDtoList.add(entrenamientoDiaDto);
        }
        return entrenamientoDiaDtoList;
    }
}
