package edu.uade.gympal.backend.model.dto;

import edu.uade.gympal.backend.model.enums.TrofeoTipo;

public class TrofeoDto {
    private TrofeoTipo trofeoTipo;
    private String nombreTrofeo;

    public TrofeoTipo getTrofeoTipo() {
        return trofeoTipo;
    }

    public void setTrofeoTipo(TrofeoTipo trofeoTipo) {
        this.trofeoTipo = trofeoTipo;
    }

    public String getNombreTrofeo() {
        return nombreTrofeo;
    }

    public void setNombreTrofeo(String nombreTrofeo) {
        this.nombreTrofeo = nombreTrofeo;
    }
}
