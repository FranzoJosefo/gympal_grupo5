package edu.uade.backend.app.model.dto;

import edu.uade.backend.app.model.enums.Sexo;

public class EstadoFisicoDto {
    private Float peso = 0f;
    private Float masaMuscular = 0f;
    private Float grasaCorporal = 0f;
    private Sexo sexo;
    private Float altura = 0f;

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
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
}

