package edu.uade.models;

import java.util.*;

/**
 * 
 */
public abstract class Operacion {

    private int operacionId;
    private EstadosList estados;
    private Comision comision;
    private int certificadoGarantia;
    private Date fechaOperacion;
    private String banco;

    public Operacion(int operacionId, EstadosList estados, Comision comision, int certificadoGarantia,
                     Date fechaOperacion, String banco) {
        this.operacionId = operacionId;
        this.estados = estados;
        this.comision = comision;
        this.certificadoGarantia = certificadoGarantia;
        this.fechaOperacion = fechaOperacion;
        this.banco = banco;
    }

    public void monetizar() {
        // TODO implement here
    }

    public void emitirCertificado() {
        // TODO implement here
    }

    public void crearOperacion() {
        // TODO implement here
    }

    public int getOperacionId() {
        return operacionId;
    }

    public EstadosList getEstados() {
        return estados;
    }

    public Comision getComision() {
        return comision;
    }

    public int getCertificadoGarantia() {
        return certificadoGarantia;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public String getBanco() {
        return banco;
    }
}