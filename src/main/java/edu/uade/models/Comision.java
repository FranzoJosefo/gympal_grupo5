package edu.uade.models;

import edu.uade.DTO.ComisionDto;
import edu.uade.DTO.EstadosListDto;
import edu.uade.enums.ComisionEstado;

import java.util.Date;

public class Comision {

    private EstadosList estadosList;
    private double valorComision;
    private double porcentajeComision;

/*    public Comision(double importebruto, double porcentajeComision) {
        this.estadosList = new EstadosList();
        Estado estado = new Estado();
        this.estadosList.agregarEstado(estado);
        this.valorComision = importebruto*(porcentajeComision/100);
        this.porcentajeComision = porcentajeComision;
    }*/

    public Comision(ComisionDto comisionDto) {
        this.estadosList = new EstadosList(comisionDto.getEstadosList());
        this.valorComision = comisionDto.getValorComision();
        this.porcentajeComision = comisionDto.getPorcentajeComision();
    }

    public EstadosList getEstadosList() {
        return estadosList;
    }

    public double getValorComision() {
        return valorComision;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void facturar() {
        // TODO implement here
    }

    public ComisionDto toDto() {
        return new ComisionDto(this.estadosList.toDto(), this.valorComision, this.porcentajeComision);
    }
}
