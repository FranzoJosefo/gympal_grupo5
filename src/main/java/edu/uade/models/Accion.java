package edu.uade.models;

import edu.uade.DTO.AccionDto;
import edu.uade.enums.TipoAccionista;

/**
 * 
 */
public class Accion {

    private int accionId;
    private TipoAccionista tipoAccionista;
    private float precio;

    public Accion(AccionDto accionDto) {
        this.accionId = accionDto.getAccionId();
        this.tipoAccionista = accionDto.getTipoAccionista();
        this.precio = accionDto.getPrecio();
    }

    public int getAccionId() {
        return accionId;
    }

    public void setAccionId(int accionId) {
        this.accionId = accionId;
    }

    public TipoAccionista getTipoAccionista() {
        return tipoAccionista;
    }

    public void setTipoAccionista(TipoAccionista tipoAccionista) {
        this.tipoAccionista = tipoAccionista;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public AccionDto toDto() {
        return new AccionDto(accionId, tipoAccionista, precio);
    }
}