package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dto.EstadoFisicoDto;
import edu.uade.backend.app.model.enums.Sexo;

public class EstadoFisico {
    private Float peso;
    private Float masaMuscular;
    private Float grasaCorporal;
    private Sexo sexo;
    private Float altura;

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

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
        dto.setSexo(getSexo());
        dto.setAltura(getAltura());
        return dto;
    }
}
