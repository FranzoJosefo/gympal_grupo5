package edu.uade.DTO;

import edu.uade.enums.TipoAccionista;

public class AccionDto {

    private int accionId;
    
    private TipoAccionista tipoAccionista;
    private float precio;

    public AccionDto(int accionId, TipoAccionista tipo, float precio) {
        this.accionId = accionId;
        this.tipoAccionista = tipo;
        this.precio = precio;
    }

    public int getAccionId() {
        return accionId;
    }

    public TipoAccionista getTipoAccionista() {
        return tipoAccionista;
    }

    public float getPrecio() {
        return precio;
    }
}
