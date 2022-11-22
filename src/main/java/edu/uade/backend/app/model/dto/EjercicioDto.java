package edu.uade.backend.app.model.dto;

import edu.uade.backend.app.model.enums.ExigenciaMuscular;
import edu.uade.backend.app.model.enums.GrupoMuscular;

public class EjercicioDto {
    private NivelAerobicoDto nivelAerobico;
    private GrupoMuscular grupoMuscular;
    private ExigenciaMuscular exigenciaMuscular;
    private int cantidadSeries;
    private int cantidadRepeticiones;
    private Float pesoAsignado;

    public NivelAerobicoDto getNivelAerobico() {
        return nivelAerobico;
    }

    public void setNivelAerobico(NivelAerobicoDto nivelAerobico) {
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

    public int getRepeticionesTotales() {
        return getCantidadRepeticiones() * getCantidadSeries();
    }
}
