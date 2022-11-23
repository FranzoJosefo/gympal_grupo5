package edu.uade.backend.app.model.dto;

import edu.uade.backend.app.model.Rutina;
import edu.uade.backend.app.model.enums.ObjetivoTipo;

public class ObjetivoDto {
    private RutinaDto rutina;
    private ObjetivoTipo objetivoTipo;
    private Boolean objetivoCumplido;
    private Float pesoInicial = 0f;

    public RutinaDto getRutina() {
        return rutina;
    }

    public void setRutina(RutinaDto rutina) {
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
}
