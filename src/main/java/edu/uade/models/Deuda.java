package edu.uade.models;

import edu.uade.DTO.DeudaDto;
import edu.uade.DTO.EstadosListDto;
import edu.uade.enums.TipoOperacion;

import java.util.Date;

public class Deuda {

    public Deuda(DeudaDto deudaDTO) {
        this.deudaId = deudaDTO.getDeudaId();
        this.estados = deudaDTO.getEstados();
        this.monto = deudaDTO.getMonto();
        this.montoMora = deudaDTO.getMontoMora();
        this.montoPendiente = deudaDTO.getMontoPendiente();
        this.fecha = deudaDTO.getFecha();
        this.tipoOperacion = deudaDTO.getTipoOperacion();
    }

    private int deudaId;
    private EstadosListDto estados;
    private double monto;
    private double montoMora;
    private double montoPendiente;
    private Date fecha;
    private TipoOperacion tipoOperacion;

    public int getDeudaId() {
        return deudaId;
    }

    public void setDeudaId(int deudaId) {
        this.deudaId = deudaId;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public void setEstados(EstadosListDto estados) {
        this.estados = estados;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMontoMora() {
        return montoMora;
    }

    public void setMontoMora(double montoMora) {
        this.montoMora = montoMora;
    }

    public double getMontoPendiente() {
        return montoPendiente;
    }

    public void setMontoPendiente(double montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public DeudaDto toDto() {
        return new DeudaDto(deudaId, estados, monto, montoMora, montoPendiente, fecha, tipoOperacion);
    }
}