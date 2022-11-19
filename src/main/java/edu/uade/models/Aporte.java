package edu.uade.models;

import edu.uade.DTO.AporteDto;

import java.util.Date;

/**
 * 
 */
public class Aporte {

    private int aporteId;
    private float monto;
    private Date fecha;

    public Aporte(AporteDto aporteDTO) {
        this.aporteId = aporteDTO.getAporteID();
        this.monto = aporteDTO.getMonto();
        this.fecha = aporteDTO.getFecha();
    }

    public void getTipoAporte() {
        // TODO implement here
    }

    public float getMonto() {
        return monto;
    }

    public int getAporteId() {
        return aporteId;
    }

    public void setAporteId(int aporteId) {
        this.aporteId = aporteId;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AporteDto toDto() {
        return new AporteDto(aporteId, monto, fecha);
    }
}