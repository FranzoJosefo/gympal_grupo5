package edu.uade.models;

import edu.uade.DTO.OperacionPrestamoDto;
import edu.uade.enums.SistemaAmortizacion;

import java.util.Date;

public class OperacionPrestamo extends Operacion {

    private double importeBruto;
    private double tasaDeInteres;
    private Date fechaAcreditacion;
    private int cantidadCuotas;
    private SistemaAmortizacion sistemaAmortizacion;
    private int cuotasPagadas;

    public OperacionPrestamo(OperacionPrestamoDto operacionPrestamoDto) {
        super(operacionPrestamoDto.getOperacionId(),
                new EstadosList(operacionPrestamoDto.getEstados()),
                new Comision(operacionPrestamoDto.getComision()),
                operacionPrestamoDto.getCertificadoGarantia(),
                operacionPrestamoDto.getFechaOperacion(),
                operacionPrestamoDto.getBanco());
        this.tasaDeInteres = operacionPrestamoDto.getTasaDeInteres();
        this.fechaAcreditacion = operacionPrestamoDto.getFechaAcreditacion();
        this.cantidadCuotas = operacionPrestamoDto.getCantidadCuotas();
        this.sistemaAmortizacion = operacionPrestamoDto.getSistemaAmortizacion();
        this.cuotasPagadas = operacionPrestamoDto.getCuotasPagadas();
        this.importeBruto = operacionPrestamoDto.getImporteBruto();
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

    public OperacionPrestamoDto toDto() {
        return new OperacionPrestamoDto(importeBruto,
                tasaDeInteres,
                fechaAcreditacion,
                cantidadCuotas,
                sistemaAmortizacion,
                cuotasPagadas,
                getOperacionId(),
                getEstados().toDto(),
                getComision().toDto(),
                getCertificadoGarantia(),
                getFechaOperacion(),
                getBanco());
    }
}