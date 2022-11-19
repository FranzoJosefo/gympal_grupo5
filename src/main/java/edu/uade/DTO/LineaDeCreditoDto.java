package edu.uade.DTO;

import edu.uade.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineaDeCreditoDto {

    private int lineaCreditoId;
    private double montoMaximo;
    private Date fechaVigencia = new Date();
    private List<ContraGarantiaDto> listadoContragarantias = new ArrayList<>();
    private double montoDisponible;
    private EstadosListDto estados;
    private List<OperacionPrestamoDto> operacionPrestamoDtoList;
    private List<OperacionChequePagareDto> operacionChequePagareDtoList;
    private List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtoList;

    public LineaDeCreditoDto(int lineaCreditoId, double montoMaximo, Date fechaVigencia, List<ContraGarantiaDto> listadoContragarantias,
                             double montoDisponible, EstadosListDto estados, List<OperacionPrestamoDto> operacionPrestamoDtoList,
                             List<OperacionChequePagareDto> operacionChequePagareDtoList, List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtoList) {
        this.lineaCreditoId = lineaCreditoId;
        this.montoMaximo = montoMaximo;
        this.fechaVigencia = fechaVigencia;
        this.listadoContragarantias = listadoContragarantias;
        this.montoDisponible = montoDisponible;
        this.estados = estados;
        this.operacionPrestamoDtoList = operacionPrestamoDtoList;
        this.operacionChequePagareDtoList = operacionChequePagareDtoList;
        this.operacionCuentaCorrienteTcDtoList = operacionCuentaCorrienteTcDtoList;
    }

    public List<ContraGarantia> getContraGarantiasFromDto() {
        List<ContraGarantia> contraGarantias = new ArrayList<>();
        for (ContraGarantiaDto currentContraGarantiasDto : this.listadoContragarantias) {
            contraGarantias.add(new ContraGarantia(currentContraGarantiasDto));
        }
        return contraGarantias;
    }

    public double getMontoMaximo() {
        return montoMaximo;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public List<ContraGarantiaDto> getListadoContragarantiasDto() {
        return listadoContragarantias;
    }

    public double getMontoDisponible() {
        return montoDisponible;
    }

    public int getLineaCreditoId() {
        return lineaCreditoId;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public List<OperacionPrestamoDto> getOperacionPrestamoDtoList() {
        return operacionPrestamoDtoList;
    }

    public void setOperacionPrestamoDtoList(List<OperacionPrestamoDto> operacionPrestamoDtoList) {
        this.operacionPrestamoDtoList = operacionPrestamoDtoList;
    }

    public List<OperacionChequePagareDto> getOperacionChequePagareDtoList() {
        return operacionChequePagareDtoList;
    }

    public void setOperacionChequePagareDtoList(List<OperacionChequePagareDto> operacionChequePagareDtoList) {
        this.operacionChequePagareDtoList = operacionChequePagareDtoList;
    }

    public List<OperacionCuentaCorrienteTcDto> getOperacionCuentaCorrienteTcDtoList() {
        return operacionCuentaCorrienteTcDtoList;
    }

    public void setOperacionCuentaCorrienteTcDtoList(List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtoList) {
        this.operacionCuentaCorrienteTcDtoList = operacionCuentaCorrienteTcDtoList;
    }
}