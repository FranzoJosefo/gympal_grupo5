package edu.uade.model.dto;

import edu.uade.model.enums.Sexo;

public class SocioDto {
    String usuario;
    ObjetivoDto objetivo;
    int edad;
    float peso;
    Sexo sexo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ObjetivoDto getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ObjetivoDto objetivo) {
        this.objetivo = objetivo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
