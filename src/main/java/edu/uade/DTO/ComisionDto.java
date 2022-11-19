package edu.uade.DTO;


public class ComisionDto {

    private EstadosListDto estadosList;
    private double valorComision;
    private double porcentajeComision;

    public ComisionDto(EstadosListDto estadosList, double importebruto, double porcentajeComision) {
        this.estadosList = estadosList;
        this.valorComision = importebruto * (porcentajeComision / 100);
        this.porcentajeComision = porcentajeComision;
    }

    public EstadosListDto getEstadosList() {
        return estadosList;
    }

    public double getValorComision() {
        return valorComision;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }
}