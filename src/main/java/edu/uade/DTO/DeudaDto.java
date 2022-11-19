package edu.uade.DTO;

import edu.uade.enums.TipoOperacion;

import java.util.Date;

public class DeudaDto {

    private int deudaId;
    private EstadosListDto estados;
    private double monto;
    private double montoMora;
    private double montoPendiente;
    private Date fecha;
    private TipoOperacion tipoOperacion;

    public DeudaDto(int deudaId, EstadosListDto estados, double monto, double montoMora,
                    double montoPendiente, Date fecha, TipoOperacion tipoOperacion) {
        this.deudaId = deudaId;
        this.estados = estados;
        this.monto = monto;
        this.montoMora = montoMora;
        this.montoPendiente = montoPendiente;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
    }

    public int getDeudaId() {
        return deudaId;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public double getMonto() {
        return monto;
    }

    public double getMontoMora() {
        return montoMora;
    }

    public double getMontoPendiente() {
        return montoPendiente;
    }

    public Date getFecha() {
        return fecha;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }
}