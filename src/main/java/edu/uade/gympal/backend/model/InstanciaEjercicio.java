package edu.uade.gympal.backend.model;

import edu.uade.gympal.backend.model.dto.InstanciaEjercicioDto;

import java.util.ArrayList;
import java.util.List;

public class InstanciaEjercicio {
    private Ejercicio ejercicio;
    private int repeticionesRealizadas;

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getRepeticionesRealizadas() {
        return repeticionesRealizadas;
    }

    public void setRepeticionesRealizadas(int repeticionesRealizadas) {
        this.repeticionesRealizadas = repeticionesRealizadas;
    }

    public void realizarRepeticiones(int repeticiones) {
        this.repeticionesRealizadas += repeticiones;
    }

    public int repeticionesRestantes() {
        return getEjercicio().repeticionesTotales() - getRepeticionesRealizadas();
    }

    public Float pesoLevantado() {
        return getRepeticionesRealizadas() * getEjercicio().getPesoAsignado();
    }

    public InstanciaEjercicioDto toDto() {
        InstanciaEjercicioDto dto = new InstanciaEjercicioDto();
        dto.setEjercicio(getEjercicio().toDto());
        dto.setRepeticionesRealizadas(getRepeticionesRealizadas());
        return dto;
    }

    public static List<InstanciaEjercicioDto> convertInstanciaEjercicioListToDto(List<InstanciaEjercicio> instanciaEjercicioList) {
        List<InstanciaEjercicioDto> instanciaEjercicioDtoList = new ArrayList<>();
        for (InstanciaEjercicio instanciaEjercicio : instanciaEjercicioList) {
            InstanciaEjercicioDto instanciaEjercicioDto = new InstanciaEjercicioDto();
            instanciaEjercicioDto.setEjercicio(instanciaEjercicio.getEjercicio().toDto());
            instanciaEjercicioDtoList.add(instanciaEjercicioDto);
        }
        return instanciaEjercicioDtoList;
    }

}
