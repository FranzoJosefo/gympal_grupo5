package edu.uade.gympal.backend.model;

import edu.uade.gympal.backend.model.dto.EjercicioDto;
import edu.uade.gympal.backend.model.enums.ExigenciaMuscular;
import edu.uade.gympal.backend.model.enums.GrupoMuscular;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
    private NivelAerobico nivelAerobico;
    private GrupoMuscular grupoMuscular;
    private ExigenciaMuscular exigenciaMuscular;
    private int cantidadSeries;
    private int cantidadRepeticiones;
    private Float pesoAsignado = 0f;
    private int duracionRepeticionSegundos;

    public int getDuracionRepeticionSegundos() {
        return duracionRepeticionSegundos;
    }

    public void setDuracionRepeticionSegundos(int duracionRepeticionSegundos) {
        this.duracionRepeticionSegundos = duracionRepeticionSegundos;
    }

    public NivelAerobico getNivelAerobico() {
        return nivelAerobico;
    }

    public int getNivelAerobicoValue() {
        return getNivelAerobico().getNivel();
    }

    public void setNivelAerobico(NivelAerobico nivelAerobico) {
        this.nivelAerobico = nivelAerobico;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public ExigenciaMuscular getExigenciaMuscular() {
        return exigenciaMuscular;
    }

    public void setExigenciaMuscular(ExigenciaMuscular exigenciaMuscular) {
        this.exigenciaMuscular = exigenciaMuscular;
    }

    public int getCantidadSeries() {
        return cantidadSeries;
    }

    public void setCantidadSeries(int cantidadSeries) {
        this.cantidadSeries = cantidadSeries;
    }

    public int getCantidadRepeticiones() {
        return cantidadRepeticiones;
    }

    public void setCantidadRepeticiones(int cantidadRepeticiones) {
        this.cantidadRepeticiones = cantidadRepeticiones;
    }

    public Float getPesoAsignado() {
        return pesoAsignado;
    }

    public void setPesoAsignado(Float pesoAsignado) {
        this.pesoAsignado = pesoAsignado;
    }

    public int repeticionesTotales() {
        return cantidadRepeticiones * cantidadSeries;
    }

    public int getTiempoTotalEjercicio() {
        return ((cantidadRepeticiones * duracionRepeticionSegundos) * cantidadSeries) / 60;
    }

    public EjercicioDto toDto() {
        EjercicioDto dto = new EjercicioDto();
        dto.setExigenciaMuscular(this.getExigenciaMuscular());
        dto.setGrupoMuscular(this.getGrupoMuscular());
        dto.setNivelAerobico(this.getNivelAerobico().toDto());
        dto.setPesoAsignado(this.getPesoAsignado());
        dto.setCantidadSeries(this.getCantidadSeries());
        dto.setCantidadRepeticiones(this.getCantidadRepeticiones());
        dto.setDuracionRepeticionSegundos(this.getDuracionRepeticionSegundos());
        return dto;
    }

    public static List<Ejercicio> ejerciciosDtoToEjercicios(List<EjercicioDto> ejercicioDtos) {
        List<Ejercicio> ejercicios = new ArrayList<>();
        for(EjercicioDto ejercicioDto : ejercicioDtos) {
            Ejercicio ejercicio = new Ejercicio();
            ejercicio.setCantidadRepeticiones(ejercicioDto.getCantidadRepeticiones());
            ejercicio.setCantidadSeries(ejercicioDto.getCantidadSeries());
            ejercicio.setDuracionRepeticionSegundos(ejercicioDto.getDuracionRepeticionSegundos());
            ejercicio.setGrupoMuscular(ejercicioDto.getGrupoMuscular());
            NivelAerobico nivelAerobico = new NivelAerobico();
            nivelAerobico.setNivel(ejercicioDto.getNivelAerobico().getNivel());
            ejercicio.setNivelAerobico(nivelAerobico);
            ejercicio.setExigenciaMuscular(ejercicioDto.getExigenciaMuscular());
            ejercicio.setPesoAsignado(ejercicioDto.getPesoAsignado());
            ejercicios.add(ejercicio);
        }
        return ejercicios;
    }
}
