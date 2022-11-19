package edu.uade.models;

import edu.uade.DTO.ContraGarantiaDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContraGarantia {

    private int contraGarantiaId;
    private float monto;
    private Date vigencia;

    public ContraGarantia(int contraGarantiaId, float monto, Date vigencia) {
        this.contraGarantiaId = contraGarantiaId;
        this.monto = monto;
        this.vigencia = vigencia;
    }

    public ContraGarantia(ContraGarantiaDto contraGarantiaDto) {
        this.contraGarantiaId = contraGarantiaDto.getContraGarantiaId();
        this.monto = contraGarantiaDto.getMonto();
        this.vigencia = contraGarantiaDto.getVigencia();
    }

    public ContraGarantiaDto toDto() {
        return new ContraGarantiaDto(this.contraGarantiaId, this.monto, this.vigencia);
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
