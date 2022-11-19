package edu.uade.DTO;

import java.util.Date;

public class OperacionChequePagareDto {

    private double importeBruto;
    private int numeroCheque;
    private Date fechaVencimiento;
    private String cuitFirmante;
    private double importeNeto;

    //Operacion attributes
    private int operacionId;
    private EstadosListDto estados;
    private ComisionDto comision;
    private int certificadoGarantia;
    private Date fechaOperacion;
    private String banco;

    public OperacionChequePagareDto(int operacionId, EstadosListDto estados, ComisionDto comision, int certificadoGarantia,
                                    Date fechaOperacion, double importeBruto, String banco,
                                    int numeroCheque, Date fechaVencimiento, String cuitFirmante, double importeNeto) {

        this.banco = banco;
        this.importeBruto = importeBruto;
        this.operacionId = operacionId;
        this.estados = estados;
        this.comision = comision;
        this.certificadoGarantia = certificadoGarantia;
        this.fechaOperacion = fechaOperacion;
        this.numeroCheque = numeroCheque;
        this.fechaVencimiento = fechaVencimiento;
        this.cuitFirmante = cuitFirmante;
        this.importeNeto = importeNeto;
    }

    public int getNumeroCheque() {
        return numeroCheque;
    }

    public String getBanco() {
        return banco;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCuitFirmante() {
        return cuitFirmante;
    }

    public double getImporteBruto() {
        return importeBruto;
    }

    public double getImporteNeto() {
        return importeNeto;
    }

    public int getOperacionId() {
        return operacionId;
    }

    public ComisionDto getComision() {
        return comision;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public int getCertificadoGarantia() {
        return certificadoGarantia;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }
}
