package edu.uade.models;

import edu.uade.DTO.ComisionDto;
import edu.uade.DTO.OperacionChequePagareDto;

import java.util.*;

/**
 *
 */
public class OperacionChequePagare extends Operacion {

    private double importeBruto;
    private int numeroCheque;
    private Date fechaVencimiento;
    private String cuitFirmante;
    private double importeNeto;

    public OperacionChequePagare(int operacionId, EstadosList estados, Comision comision, int certificadoGarantia,
                                 Date fechaOperacion, double importeBruto, String banco,
                                 int numeroCheque, Date fechaVencimiento, String cuitFirmante, double importeNeto) {
        super(operacionId, estados, comision, certificadoGarantia, fechaOperacion, banco);
        this.numeroCheque = numeroCheque;
        this.fechaVencimiento = fechaVencimiento;
        this.cuitFirmante = cuitFirmante;
        this.importeNeto = importeNeto;
        this.importeBruto = importeBruto;
    }

    public OperacionChequePagare(OperacionChequePagareDto operacionChequePagareDto) {
        super(operacionChequePagareDto.getOperacionId(),
                new EstadosList(operacionChequePagareDto.getEstados()),
                new Comision(operacionChequePagareDto.getComision()),
                operacionChequePagareDto.getCertificadoGarantia(),
                operacionChequePagareDto.getFechaOperacion(),
                operacionChequePagareDto.getBanco());
        this.numeroCheque = operacionChequePagareDto.getNumeroCheque();
        this.fechaVencimiento = operacionChequePagareDto.getFechaVencimiento();
        this.cuitFirmante = operacionChequePagareDto.getCuitFirmante();
        this.importeNeto = operacionChequePagareDto.getImporteNeto();
        this.importeBruto = operacionChequePagareDto.getImporteBruto();
    }

    public OperacionChequePagareDto toDto() {
        return new OperacionChequePagareDto(
                getOperacionId(),
                getEstados().toDto(),
                getComision().toDto(),
                getCertificadoGarantia(),
                getFechaOperacion(),
                this.importeBruto,
                getBanco(),
                this.numeroCheque,
                this.fechaVencimiento,
                this.cuitFirmante,
                this.importeNeto
        );
    }

    public int getNumeroCheque() {
        return numeroCheque;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCuitFirmante() {
        return cuitFirmante;
    }

    public double getImporteNeto() {
        return importeNeto;
    }

    public void monetizar() {
        // TODO implement here
    }

    public void getTasaDescuento() {
        // TODO implement here
    }

    public double getImporteBruto() {
        return importeBruto;
    }
}
