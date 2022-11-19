package edu.uade.controllers;

import edu.uade.DTO.*;
import edu.uade.enums.DataFilesNames;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.enums.TipoOperacion;
import edu.uade.models.*;
import edu.uade.service.ApiService;

import java.util.*;

import static edu.uade.enums.OperacionEstado.MONETIZADO_OPERADO;

public enum SocioController {
    INSTANCE;

    private List<SocioEmpresa> socios = new ArrayList<>();

    SocioController() {
        socios.addAll(getAllSociosParticipeFromDataBase());
        socios.addAll(getAllSociosProtectoresFromDataBase());
    }

    private List<SocioParticipe> getAllSociosParticipeFromDataBase() {

        List<SocioParticipeDto> dtos = ApiService.leer(SocioParticipeDto.class,
                DataFilesNames.FILE_SOCIOS_PARTICIPES.getName());

        List<SocioParticipe> sociosParticipes = new ArrayList<>();

        // Mapeo de Socios Participes
        for (SocioParticipeDto dto : dtos) {

            // Mapeo de Accionistas
            List<Accionista> accionistas = new ArrayList<>();
            for (AccionistaDto accionistaDto : dto.getAccionistas()) {
                accionistas.add(new Accionista(accionistaDto));
            }
            sociosParticipes.add(new SocioParticipe(dto));
        }

        return sociosParticipes;
    }

    private List<SocioProtector> getAllSociosProtectoresFromDataBase() {

        List<SocioProtectorDto> dtos = ApiService.leer(SocioProtectorDto.class,
                DataFilesNames.FILE_SOCIOS_PROTECTOR.getName());

        List<SocioProtector> sociosProtectores = new ArrayList<>();

        // Mapeo de Socios Protectores
        for (SocioProtectorDto dto : dtos) {

            // Mapeo de Accionistas
            List<Accionista> accionistas = new ArrayList<>();
            for (AccionistaDto accionistaDto : dto.getAccionistas()) {
                accionistas.add(new Accionista(accionistaDto));
            }
            sociosProtectores.add(new SocioProtector(dto));
        }

        return sociosProtectores;
    }

    public List<SocioEmpresa> getSocios() {
        Collections.sort(socios, Comparator.comparingInt(SocioEmpresa::getSocioId));
        return socios;
    }

    /**
     *
     */// CHEQUEAR esto TODO
    public double getFDR() {
        double FDR = 0;
        for (SocioEmpresa protector : socios) {
            if (protector instanceof SocioProtector) {
                for (Aporte aporte : ((SocioProtector) protector).getAportes()) {
                    FDR += aporte.getMonto();
                }
            }
        }
        return 100000000;//FDR;
    }

    public void socioABM() {
        // TODO implement here
    }


    public SocioEmpresa getSocio(int socioId) {
        SocioEmpresa socioSeleccionado = null;
        for (SocioEmpresa socio : socios) {
            if (socio.getSocioId() == socioId) {
                socioSeleccionado = socio;
            }
        }
        return socioSeleccionado;
    }

    /**
     * @param start
     * @param end
     * @param socioId
     */
    // Consulta 2: Las operaciones avaladas a nombre de un socio, en estado monetizadas en un período de tiempo
    public List<Operacion> getOperacionesAvaladasEnDateRange(Date start, Date end, int socioId) {
        SocioEmpresa socioSeleccionado = getSocio(socioId);
        return ((SocioParticipe) socioSeleccionado).getOpsAvaladasByRange(start, end);
    }

    public void getPromedioTasaDescuentoByRange(Date start, Date end, TamanioEmpresa tamañoEmpresa) {
        // TODO implement here
    }

    public void getPromedioTotalOperadoCheque(Date start, Date end, TamanioEmpresa tamañoEmpresa) {
        // TODO implement here
    }

    /**
     * @param socioId
     */
    public ConsultaConsolidadaDto getConsultaConsolidadaSocioDto(int socioId) {
        SocioParticipe socioEncontrado = (SocioParticipe) getSocio(socioId);
        double riesgoVivo = socioEncontrado.getLineaCredito().calcularRiesgoVivo();
        LineaDeCredito lineaDeCredito = socioEncontrado.getLineaCredito();
        double utilizadoDeLinea = lineaDeCredito.calcularUtilizadoLinea();
        List<ContraGarantiaDto> contraGarantiasListDto = lineaDeCredito.getContraGarantiasToDto();
        List<OperacionChequePagareDto> operacionChequePagareDtoList = lineaDeCredito.getOperacionesChequePagareDto(lineaDeCredito.getOperaciones());
        List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTcDtoList = lineaDeCredito.getOperacionesCuentaCorrienteTcDto(lineaDeCredito.getOperaciones());
        List<OperacionPrestamoDto> operacionPrestamoDtoList = lineaDeCredito.getOperacionesPrestamoToDto(lineaDeCredito.getOperaciones());
        List<OperacionChequePagareDto> operacionesMonetizadasChequePagareDtoList = lineaDeCredito.getOperacionesChequePagareDto(lineaDeCredito.getOperacionesByEstado(MONETIZADO_OPERADO));
        List<OperacionCuentaCorrienteTcDto> operacionesMonetizadasCuentaCorrienteTcDtoList = lineaDeCredito.getOperacionesCuentaCorrienteTcDto(lineaDeCredito.getOperacionesByEstado(MONETIZADO_OPERADO));
        List<OperacionPrestamoDto> operacionesMonetizadasPrestamoDtoList = lineaDeCredito.getOperacionesPrestamoToDto(lineaDeCredito.getOperacionesByEstado(MONETIZADO_OPERADO));
        double totalDeOperaciones = 0;
        double totalDeOperacionesMonetizadas = 0;
        for (OperacionChequePagareDto cheques : operacionesMonetizadasChequePagareDtoList) {
            totalDeOperacionesMonetizadas += cheques.getImporteBruto();
        }
        for (OperacionPrestamoDto prestamo : operacionesMonetizadasPrestamoDtoList) {
            totalDeOperacionesMonetizadas += prestamo.getImporteBruto();
        }
        for (OperacionCuentaCorrienteTcDto cc : operacionesMonetizadasCuentaCorrienteTcDtoList) {
            totalDeOperacionesMonetizadas += cc.getImporteTotal();
        }

        for (OperacionChequePagareDto cheques : operacionChequePagareDtoList) {
            totalDeOperaciones += cheques.getImporteBruto();
        }
        for (OperacionPrestamoDto prestamo : operacionPrestamoDtoList) {
            totalDeOperaciones += prestamo.getImporteBruto();
        }
        for (OperacionCuentaCorrienteTcDto cc : operacionCuentaCorrienteTcDtoList) {
            totalDeOperaciones += cc.getImporteTotal();
        }

        return new ConsultaConsolidadaDto(
                riesgoVivo,
                utilizadoDeLinea,
                contraGarantiasListDto,
                operacionChequePagareDtoList,
                operacionCuentaCorrienteTcDtoList,
                operacionPrestamoDtoList,
                operacionesMonetizadasChequePagareDtoList,
                operacionesMonetizadasCuentaCorrienteTcDtoList,
                operacionesMonetizadasPrestamoDtoList,
                totalDeOperaciones,
                totalDeOperacionesMonetizadas
        );

    }


    /**
     * @param socioId
     * @param monto
     */
    public boolean validarMontoPermitido(int socioId, double monto) {
        double montoMaximo = 0;
        double porcentajeDelFDR = 0.05;
        List<SocioParticipe> empresasConAccionistasComunes = new ArrayList<>();
        // voy a buscar la empresa
        SocioEmpresa socioSeleccionado = getSocio(socioId);

        // tengo la empresa, ahora voy a buscar las empresas que comparten accionistas
        for (SocioEmpresa socio : socios) {
            if (socio instanceof SocioParticipe) {
                boolean comparteAccionista = false;
                for (Accionista accionistaEmpresa : socio.getAccionistas()) {
                    for (Accionista accionista : socioSeleccionado.getAccionistas()) {
                        if (accionistaEmpresa.getCuit().equals(accionista.getCuit())) {
                            comparteAccionista = true;
                        }
                    }
                }
                if (comparteAccionista) {
                    empresasConAccionistasComunes.add((SocioParticipe) socio);
                }
            }
        }

        if (empresasConAccionistasComunes.isEmpty()) {
            montoMaximo = getFDR() * porcentajeDelFDR;
        } else {
            for (SocioParticipe empresa : empresasConAccionistasComunes) {
                montoMaximo = Double.sum(montoMaximo, empresa.getLineaCredito().calcularRiesgoVivo());
            }
        }

        if (monto > montoMaximo) {
            System.out.println("El monto que se quiere operar: " + monto +
                    " es mayor al permitido para este socio: " + montoMaximo);
            return false;
        }
        System.out.println("El monto que se quiere operar: " + monto +
                " esta dentro de lo  permitido para este socio: " + montoMaximo);
        return true;
    }

    // Regla 2: La SGR no puede recibir más del 5% del FDR en cheques de un mismo firmante
    public boolean validarChequesAndMontoPermitido(String cuit, double monto, int socioId) {
        double suma = 0;

        for (SocioEmpresa socio : socios) {
            if (socio instanceof SocioParticipe) {
                LineaDeCredito lineaDeCredito = ((SocioParticipe) socio).getLineaCredito();
                List<Operacion> listOperacionesMonetizadas = lineaDeCredito.getOperacionesByEstado(MONETIZADO_OPERADO);
                for (Operacion operacion : listOperacionesMonetizadas) {
                    if (operacion instanceof OperacionChequePagare && ((OperacionChequePagare) operacion).getCuitFirmante().equals(cuit)) {
                        suma += ((OperacionChequePagare) operacion).getImporteBruto();
                    }
                }
            }
        }
        suma += monto;
        return validarMontoPermitido(socioId, suma);
    }

    public void getMontoAportesTipo() {
        // TODO implement here
    }

    public void getDeudasPendientes(int socioId) {
        // TODO implement here
    }

    public void getDeudas(int socioId) {
        // TODO implement here
    }

    /**
     * Consulta General 5
     * Consulta de saldo mora. Mora de un socio por día.
     */
    public double getMoraTotalPorFecha(int socioId, Date fecha) {
        double mora = 0;
        for (SocioEmpresa socio : getSocios()) {
            if (socio.getSocioId() == (socioId) && socio instanceof SocioParticipe) {
                for (Deuda deuda : ((SocioParticipe) socio).getDeudas()) {
                    if (deuda.getFecha().equals(fecha)) {
                        mora += deuda.getMontoMora();
                    }
                }
            }
        }
        System.out.println("getMoraTotalPorFecha(" + socioId + "," + fecha + ") => " + mora);
        return mora;
    }

    public double getMoraTotal(int socioId) {
        double mora = 0;
        for (SocioEmpresa socio : getSocios()) {
            if (socio.getSocioId() == (socioId) && socio instanceof SocioParticipe) {
                for (Deuda deuda : ((SocioParticipe) socio).getDeudas()) {
                    mora += deuda.getMontoMora();
                }
            }
        }
        System.out.println("getMoraTotal(" + socioId + ") => " + mora);
        return mora;
    }

    /**
     * Regla 5
     * Un socio no puede ser aprobado como protector si es
     * accionista de una empresa socia partícipe de la SGR.
     */
    public boolean esSocioAccionista(String cuit) {

        for (SocioEmpresa socio : socios) {
            if (socio instanceof SocioParticipe) {
                for (Accionista accionista : socio.getAccionistas()) {
                    if (accionista.getCuit().equals(cuit)) {
                        System.out.println("esSocioAccionista(" + cuit + ") => true");
                        return true;
                    }
                }
            }
        }
        System.out.println("esSocioAccionista(" + cuit + ") => false");
        return false;
    }

    public boolean puedeOperar(int socioId) {
        if (getMoraTotal(socioId) == 0) {
            return true;
        }
        return false;
    }

    public double getComisionSocioByTipoOperacion(int socioId, TipoOperacion tipoOperacion) throws IllegalArgumentException {
        double comisionSocio = 0;
        try {
            for (SocioEmpresa socio : socios) {
                if (socio.getSocioId() == socioId) {
                    TablaComision tablaComisionSocio = ComisionController.INSTANCE.getTablaBySegmento(socio.getSegmentoSocio());
                    comisionSocio = tablaComisionSocio.getComisionByTipoOperacion(tipoOperacion);
                    System.out.println("getComisionSocioByTipoOperacion(" + socioId + "," + tipoOperacion + ") => " + comisionSocio);
                    return comisionSocio;
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
        return comisionSocio;
    }

    public List<SocioParticipeDto> getSociosParticipesDto() {
        List<SocioParticipeDto> socioParticipeDtoList = new ArrayList<>();
        for (SocioEmpresa socioEmpresa : socios) {
            if (socioEmpresa instanceof SocioParticipe) {
                socioParticipeDtoList.add(((SocioParticipe) socioEmpresa).toDto());
            }
        }
        Collections.sort(socioParticipeDtoList, Comparator.comparingInt(SocioParticipeDto::getSocioId));
        return socioParticipeDtoList;
    }

    public List<SocioProtectorDto> getSociosProtectoresDto() {
        List<SocioProtectorDto> socioProtectoreDtoList = new ArrayList<>();
        for (SocioEmpresa socioEmpresa : socios) {
            if (socioEmpresa instanceof SocioProtector) {
                socioProtectoreDtoList.add(((SocioProtector) socioEmpresa).toDto());
            }
        }
        Collections.sort(socioProtectoreDtoList, Comparator.comparingInt(SocioProtectorDto::getSocioId));
        return socioProtectoreDtoList;
    }

    private List<SocioParticipe> getSociosParticipes() {
        List<SocioParticipe> socioParticipeList = new ArrayList<>();
        for (SocioEmpresa socioEmpresa : socios) {
            if (socioEmpresa instanceof SocioParticipe) {
                socioParticipeList.add(((SocioParticipe) socioEmpresa));
            }
        }
        Collections.sort(socioParticipeList, Comparator.comparingInt(SocioParticipe::getSocioId));
        return socioParticipeList;
    }

    private List<SocioProtector> getSociosProtectores() {
        List<SocioProtector> socioProtectoreList = new ArrayList<>();
        for (SocioEmpresa socioEmpresa : socios) {
            if (socioEmpresa instanceof SocioProtector) {
                socioProtectoreList.add(((SocioProtector) socioEmpresa));
            }
        }
        Collections.sort(socioProtectoreList, Comparator.comparingInt(SocioProtector::getSocioId));
        return socioProtectoreList;
    }

    public List<OperacionChequePagareDto> getTasaPromedioOperadoChequeByDateRangeByTamanio(TamanioEmpresa tamanioEmpresa, Date start, Date end) {
        List<OperacionChequePagareDto> operacionChequePagareDtoList = new ArrayList<>();
        Double tasaOperadoTotal = 0.0;
        for (SocioParticipe socioParticipe : getSociosParticipesByTamanioEmpresa(tamanioEmpresa)) {
                LineaDeCredito lineaDeCredito = socioParticipe.getLineaCredito();
            tasaOperadoTotal += lineaDeCredito.getTasaOperadoChequeByDateRange(start, end);
        }
        return operacionChequePagareDtoList;
    }

    public List<OperacionChequePagareDto> getAllOperacionesChequePagareDtos() {
        List<OperacionChequePagareDto> operacionChequePagareDtoList = new ArrayList<>();
        for(SocioParticipe socioParticipe : this.getSociosParticipes()) {
            LineaDeCredito lineaDeCredito = socioParticipe.getLineaCredito();
            for(OperacionChequePagare operacionChequePagare : lineaDeCredito.getAllOperacionesChequePagare()) {
                operacionChequePagareDtoList.add(operacionChequePagare.toDto());
            }
        }

        return operacionChequePagareDtoList;
    }

    private List<SocioParticipe> getSociosParticipesByTamanioEmpresa(TamanioEmpresa tamanioEmpresa) {
        List<SocioParticipe> socioParticipeList = new ArrayList<>();
        for (SocioParticipe socioParticipe : getAllSociosParticipes()) {
            if (socioParticipe.getTamanioEmpresa() == tamanioEmpresa) {
                socioParticipeList.add(socioParticipe);
            }
        }
        return socioParticipeList;
    }

    private List<SocioParticipe> getAllSociosParticipes() {
        List<SocioParticipe> socioParticipeList = new ArrayList<>();
        for (SocioEmpresa socioEmpresa : socios) {
            if (socioEmpresa instanceof SocioParticipe) {
                socioParticipeList.add((SocioParticipe) socioEmpresa);
            }
        }
        return socioParticipeList;
    }
}
