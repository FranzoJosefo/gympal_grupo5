package edu.uade.backend.app.model.dto;

public class EstadoFisicoDto {
    private Float peso;
    private Float masaMuscular;
    private Float grasaCorporal;

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(Float masaMuscular) {
        this.masaMuscular = masaMuscular;
    }

    public Float getGrasaCorporal() {
        return grasaCorporal;
    }

    public void setGrasaCorporal(Float grasaCorporal) {
        this.grasaCorporal = grasaCorporal;
    }
}

