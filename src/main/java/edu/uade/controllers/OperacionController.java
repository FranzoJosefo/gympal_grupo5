package edu.uade.controllers;

import com.google.gson.Gson;
import edu.uade.DTO.*;
import edu.uade.enums.DataFilesNames;
import edu.uade.enums.OperacionEstado;
import edu.uade.enums.SistemaAmortizacion;
import edu.uade.enums.TipoOperacion;
import edu.uade.models.*;
import edu.uade.service.ApiService;

import java.util.*;

public enum OperacionController {
    INSTANCE;

    private List<Operacion> operaciones = new ArrayList<>();

    OperacionController() {
        operaciones.addAll(getAllChequesPagaresFromDataBase());
        operaciones.addAll(getAllPrestamosFromDataBase());
        operaciones.addAll(getAllCuentaCorrienteTCFromDataBase());
    }

    private List<OperacionChequePagare> getAllChequesPagaresFromDataBase() {
        List<OperacionChequePagareDto> dtos = ApiService.leer(OperacionChequePagareDto.class, DataFilesNames.FILE_OPS_CHEQUES_PAGARES.getName());
        List<OperacionChequePagare> operacionChequePagares = new ArrayList<>();
        for (OperacionChequePagareDto dto : dtos) {
            operacionChequePagares.add(new OperacionChequePagare(dto));
        }
        return operacionChequePagares;
    }

    private List<OperacionPrestamo> getAllPrestamosFromDataBase() {
        List<OperacionPrestamoDto> dtos = ApiService.leer(OperacionPrestamoDto.class, DataFilesNames.FILE_OPS_PRESTAMOS.getName());
        List<OperacionPrestamo> operacionPrestamos = new ArrayList<>();
        for (OperacionPrestamoDto dto : dtos) {
            operacionPrestamos.add(new OperacionPrestamo(dto));
        }
        return operacionPrestamos;
    }

    private List<OperacionCuentaCorrienteTC> getAllCuentaCorrienteTCFromDataBase() {
        List<OperacionCuentaCorrienteTcDto> dtos = ApiService.leer(OperacionCuentaCorrienteTcDto.class, DataFilesNames.FILE_OPS_TARJETAS_CUENTAS_CORRIENTES.getName());
        List<OperacionCuentaCorrienteTC> operacionCuentaCorrienteTCS = new ArrayList<>();
        for (OperacionCuentaCorrienteTcDto dto : dtos) {
            operacionCuentaCorrienteTCS.add(new OperacionCuentaCorrienteTC(dto));
        }
        return operacionCuentaCorrienteTCS;
    }

    /**
     *
     */

    // TODO agregar la variante de rami.
    //Generar OP 1
    // public static void generarOperacionChequePagare(int socioId, int operacionId,
    // Regla 2:
    // No se puede poner una operacion de un firmante, el riesgo no puede ser mayor a ese 5%.
    // Primero tomar el cuit del firmante + monto del cheque. Ir por cada operacion y si el cuit coincide lo sumo.
    // Obtengo suma de todas las operaciones de un mismo firmante. Eso mas la operacion que quiero hacer debe ser menor al 5%.
    // Todas las operaciones monetizadas. Lo que se controla es que el riesgo no sea puesto en muchas personas
    public void generarOperacionChequePagare(int socioId, int operacionId, int certificadoGarantia,
                                             Date fechaOperacion, double importeBruto, String banco,
                                             int numeroCheque, Date fechaVencimiento, String cuitFirmante) {

        if (SocioController.INSTANCE.validarChequesAndMontoPermitido(cuitFirmante, importeBruto, socioId)) {

            for (SocioEmpresa socio : SocioController.INSTANCE.getSocios()) {
                if (socio.getSocioId() == socioId) {
                    LineaDeCredito lineaDeCredito = ((SocioParticipe) socio).getLineaCredito();

                    // Estado Operación
                    EstadosListDto estados = new EstadosListDto(new ArrayList<EstadoDto>());
                    EstadoDto estado = new EstadoDto(new Date(), OperacionEstado.INGRESADO.name());
                    estados.agregarEstado(estado);

                    ComisionDto comision = new ComisionDto(estados, SocioController.INSTANCE.getComisionSocioByTipoOperacion(socioId, TipoOperacion.CHEQUE_PAGARE), importeBruto);

                    OperacionChequePagare operacionChequePagare = new OperacionChequePagare(new OperacionChequePagareDto(operacionId, estados, comision,
                            certificadoGarantia, fechaOperacion, importeBruto, banco,
                            numeroCheque, fechaVencimiento, cuitFirmante, importeBruto - comision.getValorComision()));

                    lineaDeCredito.agregarOperacion(operacionChequePagare);
                }
            }
        }

    }

    //Generar OP 2
    public static void generarOperacionTC(int socioId, int operacionId, EstadosListDto estados, Comision comision,
                                          int certificadoGarantia, Date fechaOperacion, double importeTotal, String banco,
                                          Date fechaVencimiento, double importeUtilizado) {

        if (SocioController.INSTANCE.validarMontoPermitido(socioId, importeTotal)) {

            for (SocioEmpresa socio : SocioController.INSTANCE.getSocios()) {
                if (socio.getSocioId() == socioId) {
                    LineaDeCredito lineaDeCredito = ((SocioParticipe) socio).getLineaCredito();

                    OperacionCuentaCorrienteTC operacioncuentacorrienteTC = new OperacionCuentaCorrienteTC(new OperacionCuentaCorrienteTcDto(
                            importeTotal,
                            fechaVencimiento,
                            importeUtilizado,
                            operacionId,
                            estados,
                            comision.toDto(),
                            certificadoGarantia,
                            fechaOperacion,
                            banco
                    ));
                    lineaDeCredito.agregarOperacion(operacioncuentacorrienteTC);
                }
            }
        }
    }

    //Generar OP 3
    public static void generarOperacionPrestamo(int socioId, int operacionId, EstadosListDto estados, Comision comision,
                                                int certificadoGarantia, Date fechaOperacion, double importeBruto, String banco, double tasaDeInteres,
                                                Date fechaAcreditacion, int cantidadCuotas, SistemaAmortizacion sistemaAmortizacion,
                                                int cuotasPagadas) {
        if (SocioController.INSTANCE.validarMontoPermitido(socioId, importeBruto)) {
            for (SocioEmpresa socio : SocioController.INSTANCE.getSocios()) {
                if (socio.getSocioId() == socioId) {
                    LineaDeCredito lineaDeCredito = ((SocioParticipe) socio).getLineaCredito();
                    OperacionPrestamo operacionPrestamo = new OperacionPrestamo(new OperacionPrestamoDto(importeBruto, tasaDeInteres, fechaAcreditacion,
                            cantidadCuotas, sistemaAmortizacion, cuotasPagadas, operacionId, estados, comision.toDto(), certificadoGarantia, fechaOperacion, banco));
                    lineaDeCredito.agregarOperacion(operacionPrestamo);
                }
            }
        }
    }

    public double comisionesDiariasChequesPresentados(Date dia) {

        double totalComisiones = 0;

        for (Operacion operacion : operaciones) {
            Comision comision = operacion.getComision();
            for (Estado estado : comision.getEstadosList().getEstados()) {
                if (estado.getFecha().equals(dia)
                        && estado.getNombre().equals(OperacionEstado.MONETIZADO_OPERADO.name())) {
                    totalComisiones += comision.getValorComision();
                }
            }
        }

        System.out.println("comisionesDiariasChequesPresentados(" + dia + ") => " + totalComisiones);
        return totalComisiones;
    }

    public void generarDesembolso(int operacionId) {
        // TODO implement here
    }

    public void generarAporte() {
        // TODO implement here
    }

    public List<OperacionChequePagare> getChequesByBanco(String bancoNombre) {
        List<OperacionChequePagare> operacionesCheques = new ArrayList<>();
        for (Operacion operacion : operaciones) {
            if (operacion instanceof OperacionChequePagare) {
                String currentBanco = operacion.getBanco();
                if (currentBanco.equals(bancoNombre)) {
                    operacionesCheques.add((OperacionChequePagare) operacion);
                }
            }
        }
        System.out.println("getChequesByBanco(" + bancoNombre + ") => " + new Gson().toJson(operacionesCheques));
        return operacionesCheques;
    }

    public List<OperacionPrestamoDto> getOperacionesPrestamoDtos() {
        List<OperacionPrestamoDto> operacionPrestamoDtoList = new ArrayList<>();
        for(Operacion operacion : operaciones){
            if(operacion instanceof OperacionPrestamo) {
                operacionPrestamoDtoList.add(((OperacionPrestamo) operacion).toDto());
            }
        }
        Collections.sort(operacionPrestamoDtoList, Comparator.comparingInt(OperacionPrestamoDto::getOperacionId));
        return operacionPrestamoDtoList;
    }

    public List<OperacionChequePagareDto> getOperacionesChequePagaresDtos() {
        List<OperacionChequePagareDto> operacionChequePagareDtoList = new ArrayList<>();
        for(Operacion operacion : operaciones){
            if(operacion instanceof OperacionChequePagare) {
                operacionChequePagareDtoList.add(((OperacionChequePagare) operacion).toDto());
            }
        }
        Collections.sort(operacionChequePagareDtoList, Comparator.comparingInt(OperacionChequePagareDto::getOperacionId));
        return operacionChequePagareDtoList;
    }

    public List<OperacionCuentaCorrienteTcDto> getOperacionesCuentaCorrienteTcDtos() {
        List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtos = new ArrayList<>();
        for(Operacion operacion : operaciones){
            if(operacion instanceof OperacionCuentaCorrienteTC) {
                operacionCuentaCorrienteTcDtos.add(((OperacionCuentaCorrienteTC) operacion).toDto());
            }
        }
        Collections.sort(operacionCuentaCorrienteTcDtos, Comparator.comparingInt(OperacionCuentaCorrienteTcDto::getOperacionId));
        return operacionCuentaCorrienteTcDtos;
    }
}
