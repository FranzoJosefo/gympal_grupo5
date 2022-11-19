package edu.uade.DTO;

import java.util.Date;

/**
 * 
 */
public class ContraGarantiaDto {

    private int contraGarantiaId;
    private float monto;
    private Date vigencia;

    public ContraGarantiaDto(int contraGarantiaId, float monto, Date vigencia) {
        this.contraGarantiaId = contraGarantiaId;
        this.monto = monto;
        this.vigencia = vigencia;
    }

    public int getContraGarantiaId() {
        return contraGarantiaId;
    }

    public void setContraGarantiaId(int contraGarantiaId) {
        this.contraGarantiaId = contraGarantiaId;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }
}