package edu.uade.models;

import edu.uade.DTO.OperacionCuentaCorrienteTcDto;

import java.util.Date;

public class OperacionCuentaCorrienteTC extends Operacion {

    private double importeTotal;
    private Date fechaVencimiento;
    private double importeUtilizado;

    public OperacionCuentaCorrienteTC(OperacionCuentaCorrienteTcDto operacionCuentaCorrienteTcDto) {
        super(operacionCuentaCorrienteTcDto.getOperacionId(),
                new EstadosList(operacionCuentaCorrienteTcDto.getEstados()),
                new Comision(operacionCuentaCorrienteTcDto.getComision()),
                operacionCuentaCorrienteTcDto.getCertificadoGarantia(),
                operacionCuentaCorrienteTcDto.getFechaOperacion(),
                operacionCuentaCorrienteTcDto.getBanco());
        this.fechaVencimiento = operacionCuentaCorrienteTcDto.getFechaVencimiento();
        this.importeUtilizado = operacionCuentaCorrienteTcDto.getImporteUtilizado();
        this.importeTotal = operacionCuentaCorrienteTcDto.getImporteTotal();
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

    public OperacionCuentaCorrienteTcDto toDto() {
        return new OperacionCuentaCorrienteTcDto(
                importeTotal,
                fechaVencimiento,
                importeUtilizado,
                getOperacionId(),
                getEstados().toDto(),
                getComision().toDto(),
                getCertificadoGarantia(),
                getFechaOperacion(),
                getBanco());
    }
}