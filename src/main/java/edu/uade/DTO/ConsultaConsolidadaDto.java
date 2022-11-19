package edu.uade.DTO;

import edu.uade.models.*;

import java.util.List;

public class ConsultaConsolidadaDto {

    private double riesgoVivo;
    private double utilizadoDeLinea;
    private List <ContraGarantiaDto> contraGarantiasDtoList;
    private List <OperacionChequePagareDto> operacionChequePagareDto;
    private List <OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtos;
    private List <OperacionPrestamoDto> operacionPrestamoDtos;
    private List <OperacionChequePagareDto> operacionesMonetizadasChequePagareDtoList;
    private List<OperacionCuentaCorrienteTcDto> operacionesMonetizadasCuentaCorrienteTcDtoList;
    private List<OperacionPrestamoDto> operacionesMonetizadasPrestamoDtoList;
    private double totalDeOperaciones;
    private double totalDeOperacionesMonetizadas;

    public double getTotalDeOperaciones() {
        return totalDeOperaciones;
    }

    public void setTotalDeOperaciones(double totalDeOperaciones) {
        this.totalDeOperaciones = totalDeOperaciones;
    }

    public double getTotalDeOperacionesMonetizadas() {
        return totalDeOperacionesMonetizadas;
    }

    public void setTotalDeOperacionesMonetizadas(double totalDeOperacionesMonetizadas) {
        this.totalDeOperacionesMonetizadas = totalDeOperacionesMonetizadas;
    }

    public ConsultaConsolidadaDto(
            double riesgoVivo,
            double utilizadoDeLinea,
            List <ContraGarantiaDto> contraGarantiasDtoList,
            List <OperacionChequePagareDto> operacionChequePagareDto,
            List <OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtos,
            List <OperacionPrestamoDto> operacionPrestamoDtos,
            List <OperacionChequePagareDto> operacionesMonetizadasChequePagareDtoList,
            List <OperacionCuentaCorrienteTcDto> operacionesMonetizadasCuentaCorrienteTcDtoList,
            List <OperacionPrestamoDto> operacionesMonetizadasPrestamoDtoList,
            double totalDeOperaciones,
            double totalDeOperacionesMonetizadas
    ) {
        this.riesgoVivo = riesgoVivo;
        this.utilizadoDeLinea = utilizadoDeLinea;
        this.contraGarantiasDtoList = contraGarantiasDtoList;
        this.operacionChequePagareDto = operacionChequePagareDto;
        this.operacionCuentaCorrienteTcDtos = operacionCuentaCorrienteTcDtos;
        this.operacionPrestamoDtos = operacionPrestamoDtos;
        this.operacionesMonetizadasChequePagareDtoList = operacionesMonetizadasChequePagareDtoList;
        this.operacionesMonetizadasCuentaCorrienteTcDtoList = operacionesMonetizadasCuentaCorrienteTcDtoList;
        this.operacionesMonetizadasPrestamoDtoList = operacionesMonetizadasPrestamoDtoList;
        this.totalDeOperaciones = totalDeOperaciones ;
        this.totalDeOperacionesMonetizadas = totalDeOperacionesMonetizadas;
    }

    public double getRiesgoVivo() {
        return riesgoVivo;
    }

    public void setRiesgoVivo(double riesgoVivo) {
        this.riesgoVivo = riesgoVivo;
    }

    public double getUtilizadoDeLinea() {
        return utilizadoDeLinea;
    }

    public void setUtilizadoDeLinea(double utilizadoDeLinea) {
        this.utilizadoDeLinea = utilizadoDeLinea;
    }

    public List<ContraGarantiaDto> getContraGarantiasDtoList() {
        return contraGarantiasDtoList;
    }

    public void setContraGarantiasDtoList(List<ContraGarantiaDto> contraGarantiasDtoList) {
        this.contraGarantiasDtoList = contraGarantiasDtoList;
    }

    public List<OperacionChequePagareDto> getOperacionChequePagareDto() {
        return operacionChequePagareDto;
    }

    public void setOperacionChequePagareDto(List<OperacionChequePagareDto> operacionChequePagareDto) {
        this.operacionChequePagareDto = operacionChequePagareDto;
    }

    public List<OperacionCuentaCorrienteTcDto> getOperacionCuentaCorrienteTcDtos() {
        return operacionCuentaCorrienteTcDtos;
    }

    public void setOperacionCuentaCorrienteTcDtos(List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtos) {
        this.operacionCuentaCorrienteTcDtos = operacionCuentaCorrienteTcDtos;
    }

    public List<OperacionPrestamoDto> getOperacionPrestamoDtos() {
        return operacionPrestamoDtos;
    }

    public void setOperacionPrestamoDtos(List<OperacionPrestamoDto> operacionPrestamoDtos) {
        this.operacionPrestamoDtos = operacionPrestamoDtos;
    }

    public List<OperacionChequePagareDto> getOperacionesMonetizadasChequePagareDtoList() {
        return operacionesMonetizadasChequePagareDtoList;
    }

    public void setOperacionesMonetizadasChequePagareDtoList(List<OperacionChequePagareDto> operacionesMonetizadasChequePagareDtoList) {
        this.operacionesMonetizadasChequePagareDtoList = operacionesMonetizadasChequePagareDtoList;
    }

    public List<OperacionCuentaCorrienteTcDto> getOperacionesMonetizadasCuentaCorrienteTcDtoList() {
        return operacionesMonetizadasCuentaCorrienteTcDtoList;
    }

    public void setOperacionesMonetizadasCuentaCorrienteTcDtoList(List<OperacionCuentaCorrienteTcDto> operacionesMonetizadasCuentaCorrienteTcDtoList) {
        this.operacionesMonetizadasCuentaCorrienteTcDtoList = operacionesMonetizadasCuentaCorrienteTcDtoList;
    }

    public List<OperacionPrestamoDto> getOperacionesMonetizadasPrestamoDtoList() {
        return operacionesMonetizadasPrestamoDtoList;
    }

    public void setOperacionesMonetizadasPrestamoDtoList(List<OperacionPrestamoDto> operacionesMonetizadasPrestamoDtoList) {
        this.operacionesMonetizadasPrestamoDtoList = operacionesMonetizadasPrestamoDtoList;
    }
}
