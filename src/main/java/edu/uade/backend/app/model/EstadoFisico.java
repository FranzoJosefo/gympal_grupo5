package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dto.EstadoFisicoDto;

public class EstadoFisico {
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

    public EstadoFisicoDto toDto() {
        EstadoFisicoDto dto = new EstadoFisicoDto();
        dto.setGrasaCorporal(getGrasaCorporal());
        dto.setPeso(getPeso());
        dto.setMasaMuscular(getMasaMuscular());
        return dto;
    }
}
