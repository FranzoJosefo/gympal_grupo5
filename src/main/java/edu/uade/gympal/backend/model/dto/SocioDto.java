package edu.uade.gympal.backend.model.dto;

import java.util.List;

public class SocioDto {
    String usuario;
    ObjetivoDto objetivo;
    int edad;

    List<TrofeoDto> trofeos;

    EstadoFisicoDto estadoFisico;

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

    public EstadoFisicoDto getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(EstadoFisicoDto estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public void setRutinaObjetivo(RutinaDto rutina) {
        getObjetivo().setRutina(rutina);
    }

}
