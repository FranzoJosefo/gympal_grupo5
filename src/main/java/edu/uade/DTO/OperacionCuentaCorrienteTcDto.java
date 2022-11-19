package edu.uade.DTO;

import java.util.Date;

public class OperacionCuentaCorrienteTcDto {
    private double importeTotal;
    private Date fechaVencimiento;
    private double importeUtilizado;

    //Operacion attributes
    // git test
    private int operacionId;
    private EstadosListDto estados;
    private ComisionDto comision;
    private int certificadoGarantia;
    private Date fechaOperacion;
    private String banco;

    public OperacionCuentaCorrienteTcDto(double importeTotal, Date fechaVencimiento, double importeUtilizado, int operacionId, EstadosListDto estados, ComisionDto comision, int certificadoGarantia, Date fechaOperacion, String banco) {
        this.importeTotal = importeTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.importeUtilizado = importeUtilizado;
        this.operacionId = operacionId;
        this.estados = estados;
        this.comision = comision;
        this.certificadoGarantia = certificadoGarantia;
        this.fechaOperacion = fechaOperacion;
        this.banco = banco;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getImporteUtilizado() {
        return importeUtilizado;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setImporteUtilizado(double importeUtilizado) {
        this.importeUtilizado = importeUtilizado;
    }

    public int getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(int operacionId) {
        this.operacionId = operacionId;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public void setEstados(EstadosListDto estados) {
        this.estados = estados;
    }

    public ComisionDto getComision() {
        return comision;
    }

    public void setComision(ComisionDto comision) {
        this.comision = comision;
    }

    public int getCertificadoGarantia() {
        return certificadoGarantia;
    }

    public void setCertificadoGarantia(int certificadoGarantia) {
        this.certificadoGarantia = certificadoGarantia;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
