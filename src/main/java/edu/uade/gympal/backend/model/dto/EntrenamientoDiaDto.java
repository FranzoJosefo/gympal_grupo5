package edu.uade.gympal.backend.model.dto;

import java.time.DayOfWeek;
import java.util.List;

public class EntrenamientoDiaDto {
    private List<InstanciaEjercicioDto> ejerciciosDelDia;
    private DayOfWeek dia;

    public List<InstanciaEjercicioDto> getEjerciciosDelDia() {
        return ejerciciosDelDia;
    }

    public void setEjerciciosDelDia(List<InstanciaEjercicioDto> ejerciciosDelDia) {
        this.ejerciciosDelDia = ejerciciosDelDia;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public boolean estaCompleto() {
        for (InstanciaEjercicioDto ejercicio : ejerciciosDelDia) {
            if (!ejercicio.estaCompleto()) {
                return false;
            }
        }
        return true;
    }
}
