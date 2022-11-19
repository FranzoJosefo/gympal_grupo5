package edu.uade.models;

import edu.uade.DTO.*;
import edu.uade.enums.OperacionEstado;
import edu.uade.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineaDeCredito {

    private int lineaCreditoId;
    private double montoMaximo;
    private Date fechaVigencia;
    private List<ContraGarantia> listadoContragarantias = new ArrayList<>();
    private double montoDisponible;
    private EstadosList estados = new EstadosList();
    private List<Operacion> operaciones = new ArrayList<>();

    public LineaDeCredito() {
    }

    public LineaDeCredito(LineaDeCreditoDto lineaDeCreditoDTO) {
        this.montoMaximo = lineaDeCreditoDTO.getMontoMaximo();
        this.fechaVigencia = lineaDeCreditoDTO.getFechaVigencia();
        this.listadoContragarantias = lineaDeCreditoDTO.getContraGarantiasFromDto();
        this.montoDisponible = lineaDeCreditoDTO.getMontoDisponible();
        this.lineaCreditoId = lineaDeCreditoDTO.getLineaCreditoId();
        this.estados = new EstadosList(lineaDeCreditoDTO.getEstados());
        this.operaciones = generateListaOperacionesFromDto(lineaDeCreditoDTO);
    }

    public List<Operacion> generateListaOperacionesFromDto(LineaDeCreditoDto lineaDeCreditoDto) {
        List<Operacion> operaciones = new ArrayList<>();
        operaciones.addAll(this.getOperacionChequePagareListFromDto(lineaDeCreditoDto.getOperacionChequePagareDtoList()));
        operaciones.addAll(this.getOperacionCuentaCorrienteListFromDto(lineaDeCreditoDto.getOperacionCuentaCorrienteTcDtoList()));
        operaciones.addAll(this.getOperacionPrestamoListFromDto(lineaDeCreditoDto.getOperacionPrestamoDtoList()));
        return operaciones;
    }

    public LineaDeCreditoDto toDto() {
        return new LineaDeCreditoDto(
                this.lineaCreditoId,
                this.montoMaximo,
                this.fechaVigencia,
                getContraGarantiasToDto(),
                this.montoDisponible,
                this.estados.toDto(),
                getOperacionesPrestamoToDto(this.operaciones),
                getOperacionesChequePagareDto(this.operaciones),
                getOperacionesCuentaCorrienteTcDto(this.operaciones));
    }

    public List<ContraGarantiaDto> getContraGarantiasToDto() {
        List<ContraGarantiaDto> contraGarantiasDtos = new ArrayList<>();
        for (ContraGarantia currentContraGarantias : this.listadoContragarantias) {
            contraGarantiasDtos.add(currentContraGarantias.toDto());
        }
        return contraGarantiasDtos;
    }

    public List<OperacionPrestamoDto> getOperacionesPrestamoToDto(List<Operacion> operaciones) {
        List<OperacionPrestamoDto> operacionPrestamoDtoList = new ArrayList<>();
        for (Operacion operacion : operaciones) {
            if (operacion instanceof OperacionPrestamo) {
                operacionPrestamoDtoList.add(((OperacionPrestamo) operacion).toDto());
            }
        }
        return operacionPrestamoDtoList;
    }

    public List<OperacionChequePagareDto> getOperacionesChequePagareDto(List<Operacion> operaciones) {
        List<OperacionChequePagareDto> operacionChequePagareDtoList = new ArrayList<>();
        for (Operacion operacion : operaciones) {
            if (operacion instanceof OperacionChequePagare) {
                operacionChequePagareDtoList.add(((OperacionChequePagare) operacion).toDto());
            }
        }
        return operacionChequePagareDtoList;
    }

    public List<OperacionCuentaCorrienteTcDto> getOperacionesCuentaCorrienteTcDto(List<Operacion> operaciones) {
        List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtoList = new ArrayList<>();
        for (Operacion operacion : operaciones) {
            if (operacion instanceof OperacionCuentaCorrienteTC) {
                operacionCuentaCorrienteTcDtoList.add(((OperacionCuentaCorrienteTC) operacion).toDto());
            }
        }
        return operacionCuentaCorrienteTcDtoList;
    }

    public List<OperacionPrestamo> getOperacionPrestamoListFromDto(List<OperacionPrestamoDto> operacionPrestamoDtoList) {
        List<OperacionPrestamo> operacionPrestamoList = new ArrayList<>();
        for (OperacionPrestamoDto currentPrestamoDto : operacionPrestamoDtoList) {
            operacionPrestamoList.add(new OperacionPrestamo(currentPrestamoDto));
        }
        return operacionPrestamoList;
    }

    public List<OperacionChequePagare> getOperacionChequePagareListFromDto(List<OperacionChequePagareDto> operacionChequePagareDtoList) {
        List<OperacionChequePagare> operacionChequePagareList = new ArrayList<>();
        for (OperacionChequePagareDto currentChequePagareDto : operacionChequePagareDtoList) {
            operacionChequePagareList.add(new OperacionChequePagare(currentChequePagareDto));
        }
        return operacionChequePagareList;
    }

    public List<OperacionCuentaCorrienteTC> getOperacionCuentaCorrienteListFromDto(List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtoList) {
        List<OperacionCuentaCorrienteTC> operacionCuentaCorrienteTCList = new ArrayList<>();
        for (OperacionCuentaCorrienteTcDto currentCuentaCorrienteDto : operacionCuentaCorrienteTcDtoList) {
            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTC(currentCuentaCorrienteDto));
        }
        return operacionCuentaCorrienteTCList;
    }

    public void agregarOperacion(Operacion operacion) {
        operaciones.add(operacion);
    }

    public double calcularRiesgoVivo() {
        List<Operacion> operacionesMonetizadas = getOperacionesByEstado(OperacionEstado.MONETIZADO_OPERADO);
        double sumatoria = 0;
        Date today = new Date();
        for (Operacion operacion : operacionesMonetizadas) {
            if (operacion instanceof OperacionChequePagare) {
                if(((OperacionChequePagare) operacion).getFechaVencimiento().before(today)){
                    sumatoria += ((OperacionChequePagare) operacion).getImporteBruto();
                }
            } else if (operacion instanceof OperacionCuentaCorrienteTC) {
                if(((OperacionCuentaCorrienteTC) operacion).getFechaVencimiento().before(today)){
                    sumatoria += ((OperacionCuentaCorrienteTC) operacion).getImporteUtilizado();
                }
            } else {
                sumatoria += ((OperacionPrestamo) operacion).getImporteBruto() - (((OperacionPrestamo) operacion).getImporteBruto() / ((OperacionPrestamo) operacion).getCantidadCuotas()) * ((OperacionPrestamo) operacion).getCuotasPagadas();
            }
        }
        return sumatoria;
    }

    public double calcularUtilizadoLinea() {
        //El utilizado de la línea se compone por todas las operaciones con certificado emitido más el riesgo vivo del socio.
        double total = calcularRiesgoVivo();
        List<Operacion> operacionesCertificadas = getOperacionesByEstado(OperacionEstado.CON_CERTIFICADO_EMITIDO);
        for (Operacion operacion : operacionesCertificadas) {
            if (operacion instanceof OperacionChequePagare) {
                total += ((OperacionChequePagare) operacion).getImporteBruto();
            } else if (operacion instanceof OperacionCuentaCorrienteTC) {
                total += ((OperacionCuentaCorrienteTC) operacion).getImporteTotal();
            } else {
                total += ((OperacionPrestamo) operacion).getImporteBruto();
            }
        }
        return total;
    }

    //Las operaciones avaladas a nombre de un socio, en un período de tiempo
    public List<Operacion> getOperacionesByDateRange(Date start, Date end) {
        List<Operacion> operacionesPorDate = new ArrayList<>();
        for (Operacion operacion : this.operaciones) {
            Date fechaOperacion = operacion.getFechaOperacion();
            // TODO implement here
            if (fechaOperacion.after(start) && fechaOperacion.before(end)) {
                operacionesPorDate.add(operacion);
            }
        }
        return operacionesPorDate;
    }

    // Consulta 2: Las operaciones avaladas a nombre de un socio, en estado monetizadas en un período de tiempo
    public List<Operacion> getOperacionesByDateRangeAndEstado(Date start, Date end, OperacionEstado estado) {
        List<Operacion> operaciones = new ArrayList<>();
        for (Operacion operacion : this.operaciones) {
            Date fechaOperacion = operacion.getFechaOperacion();
            if (fechaOperacion.after(start) && fechaOperacion.before(end) && estado.equals(OperacionEstado.MONETIZADO_OPERADO)) {
                operaciones.add(operacion);
            }
        }
        return operaciones;
    }

    public List<Operacion> getOperacionesByEstado(OperacionEstado estado) {

        List<Operacion> operacionesResultado = new ArrayList<>();
        for (Operacion operacion : this.operaciones) {
            // TODO implement here
            if (estado == estado) {
                operacionesResultado.add(operacion);
            }
        }
        return operacionesResultado;
    }

    public double getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(float montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public List<ContraGarantia> getListadoContragarantias() {
        return listadoContragarantias;
    }

    public void setListadoContragarantias(List<ContraGarantia> listadoContragarantias) {
        this.listadoContragarantias = listadoContragarantias;
    }

    public double getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(float montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public int getLineaCreditoId() {
        return lineaCreditoId;
    }

    public void setLineaCreditoId(int lineaCreditoId) {
        this.lineaCreditoId = lineaCreditoId;
    }

    public EstadosList getEstados() {
        return estados;
    }

    public void setEstados(EstadosList estados) {
        this.estados = estados;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public Double getTasaOperadoChequeByDateRange(Date start, Date end) {
        double totalOperado = 0.0;
        for (Operacion operacion : getOperaciones()) {
            if(operacion instanceof OperacionChequePagare) {
                Date operationDate = operacion.getFechaOperacion();
                if (operationDate.after(start) && operationDate.before(end)) {
                    totalOperado += ((OperacionChequePagare) operacion).getImporteBruto();
                    //TODO taza de descuento??? :/ aca deberia tambien pedirla y devolver totalOperado
                }
            }

        }
        return totalOperado;
    }

    public List<OperacionChequePagare> getAllOperacionesChequePagare() {
        List<OperacionChequePagare> operacionChequePagareList = new ArrayList<>();
        for(Operacion operacion : getOperaciones()) {
            if(operacion instanceof OperacionChequePagare) {
                operacionChequePagareList.add((OperacionChequePagare) operacion);
            }
        }
        return operacionChequePagareList;
    }
}
