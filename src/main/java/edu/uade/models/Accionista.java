package edu.uade.models;

import edu.uade.DTO.AccionistaDto;
import edu.uade.enums.TipoAccionista;

/**
 * 
 */
public class Accionista {

    private int accionistaId;
    private String cuit;
    private String razonSocial;
    private double participacionPorcentaje;
    private TipoAccionista tipoAccionista;

    public Accionista(AccionistaDto accionistaDto) {
        this.accionistaId = accionistaDto.getAccionistaId();
        this.cuit = accionistaDto.getCuit();
        this.razonSocial = accionistaDto.getRazonSocial();
        this.participacionPorcentaje = accionistaDto.getParticipacionPorcentaje();
        this.tipoAccionista = accionistaDto.getTipoAccionista();
    }

    public int getAccionistaId() {
        return accionistaId;
    }

    public void setAccionistaId(int accionistaId) {
        this.accionistaId = accionistaId;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public double getParticipacionPorcentaje() {
        return participacionPorcentaje;
    }

    public void setParticipacionPorcentaje(double participacionPorcentaje) {
        this.participacionPorcentaje = participacionPorcentaje;
    }

    public TipoAccionista getTipoAccionista() {
        return tipoAccionista;
    }

    public void setTipoAccionista(TipoAccionista tipoAccionista) {
        this.tipoAccionista = tipoAccionista;
    }

    public AccionistaDto toDto() {
        return new AccionistaDto(accionistaId, cuit, razonSocial, participacionPorcentaje, tipoAccionista);
    }
}