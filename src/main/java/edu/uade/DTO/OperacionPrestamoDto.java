package edu.uade.DTO;

import edu.uade.enums.SistemaAmortizacion;

import java.util.Date;

public class OperacionPrestamoDto {
    private double importeBruto;
    private double tasaDeInteres;
    private Date fechaAcreditacion;
    private int cantidadCuotas;
    private SistemaAmortizacion sistemaAmortizacion;
    private int cuotasPagadas;

    //Operacion attributes
    private int operacionId;
    private EstadosListDto estados;
    private ComisionDto comision;
    private int certificadoGarantia;
    private Date fechaOperacion;
    private String banco;

    public OperacionPrestamoDto(double importeBruto, double tasaDeInteres,
                                Date fechaAcreditacion, int cantidadCuotas,
                                SistemaAmortizacion sistemaAmortizacion, int cuotasPagadas,
                                int operacionId, EstadosListDto estados, ComisionDto comision,
                                int certificadoGarantia, Date fechaOperacion, String banco) {
        this.importeBruto = importeBruto;
        this.tasaDeInteres = tasaDeInteres;
        this.fechaAcreditacion = fechaAcreditacion;
        this.cantidadCuotas = cantidadCuotas;
        this.sistemaAmortizacion = sistemaAmortizacion;
        this.cuotasPagadas = cuotasPagadas;
        this.operacionId = operacionId;
        this.estados = estados;
        this.comision = comision;
        this.certificadoGarantia = certificadoGarantia;
        this.fechaOperacion = fechaOperacion;
        this.banco = banco;
    }

    public double getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(double importeBruto) {
        this.importeBruto = importeBruto;
    }

    public double getTasaDeInteres() {
        return tasaDeInteres;
    }

    public void setTasaDeInteres(double tasaDeInteres) {
        this.tasaDeInteres = tasaDeInteres;
    }

    public Date getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    public void setFechaAcreditacion(Date fechaAcreditacion) {
        this.fechaAcreditacion = fechaAcreditacion;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public SistemaAmortizacion getSistemaAmortizacion() {
        return sistemaAmortizacion;
    }

    public void setSistemaAmortizacion(SistemaAmortizacion sistemaAmortizacion) {
        this.sistemaAmortizacion = sistemaAmortizacion;
    }

    public int getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(int cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
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
