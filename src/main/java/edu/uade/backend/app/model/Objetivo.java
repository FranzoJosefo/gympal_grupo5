package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dto.ObjetivoDto;
import edu.uade.backend.app.model.enums.ObjetivoTipo;
import edu.uade.backend.app.model.strategies.IEntrenamientoStrategy;

import java.time.DayOfWeek;

public class Objetivo {
    private Rutina rutina;
    private ObjetivoTipo objetivoTipo;
    private Boolean objetivoCumplido;
    private Float pesoInicial;

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public ObjetivoTipo getObjetivoTipo() {
        return objetivoTipo;
    }

    public void setObjetivoTipo(ObjetivoTipo objetivoTipo) {
        this.objetivoTipo = objetivoTipo;
    }

    public Boolean getObjetivoCumplido() {
        return objetivoCumplido;
    }

    public void setObjetivoCumplido(Boolean objetivoCumplido) {
        this.objetivoCumplido = objetivoCumplido;
    }

    public Float getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Float pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public ObjetivoDto toDto() {
        ObjetivoDto dto = new ObjetivoDto();
        dto.setObjetivoTipo(getObjetivoTipo());
//        dto.setRutina(getRutina().toDto());
        dto.setObjetivoCumplido(getObjetivoCumplido());
        dto.setPesoInicial(getPesoInicial());
        return dto;
    }

    private void createRutina() {
        //TODO magia RutinaFactory
        rutina = new Rutina(); //Por ahora
    }
}
