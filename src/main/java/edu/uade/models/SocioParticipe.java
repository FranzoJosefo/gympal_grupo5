package edu.uade.models;

import edu.uade.DTO.*;
import edu.uade.controllers.DeudaController;
import edu.uade.enums.OperacionEstado;
import edu.uade.enums.SegmentoSocio;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocioParticipe extends SocioEmpresa {

    private LineaDeCredito lineaDeCredito;
    private List<Deuda> deudas;

    public SocioParticipe(SocioParticipeDto socioParticipeDto) {

        super(
                socioParticipeDto.getSocioId(),
                socioParticipeDto.getCuit(),
                socioParticipeDto.getRazonSocial(),
                socioParticipeDto.getFecha(),
                socioParticipeDto.getTamanioEmpresa(),
                socioParticipeDto.getActividadPrincipal(),
                socioParticipeDto.getDireccion(),
                socioParticipeDto.getTelefono(),
                socioParticipeDto.getMail(),
                socioParticipeDto.getPostulante(),
                Utils.createAccionesFromDto(socioParticipeDto.getAcciones()),
                Utils.createAccionistasFromDto(socioParticipeDto.getAccionistas()),
                socioParticipeDto.getSegmentoSocio(),
                new EstadosList(socioParticipeDto.getEstados()));

        this.deudas = Utils.createDeudasFromDto(socioParticipeDto.getDeudas());
        this.lineaDeCredito = socioParticipeDto.getLineaCredito() != null ? new LineaDeCredito(socioParticipeDto.getLineaCredito()) : null;
    }

    public SocioParticipeDto toDto() {
        return new SocioParticipeDto(getSocioId(),
                getCuit(),
                getRazonSocial(),
                getFecha(),
                getTamanioEmpresa(),
                getActividadPrincipal(),
                getDireccion(),
                String.valueOf(getTelefono()),
                getMail(),
                getPostulante(),
                getAccionesToDto(),
                accionistasToDto(),
                getSegmentoSocio(),
                getEstados().toDto(),
                DeudaController.INSTANCE.deudasToDto(deudas),
                lineaDeCredito != null ? lineaDeCredito.toDto() : null);
    }

    /**
     * Solo tendra una linea de credito, no hace falta tener varias.
     */
    private List<LineaDeCredito> lineasDeCreditoList;

    public List<ContraGarantia> getContraGarantias() {
        return this.lineaDeCredito.getListadoContragarantias();
    }

    public List<Operacion> getOpsAvaladasByRange(Date start, Date end) {
        LineaDeCredito lineaDeCredito = getLineaCredito();
        lineaDeCredito.getOperacionesByDateRange(start, end);
        return null;
    }

    public void getPromedioTasaDescuentoByRange() {
        // TODO implement here
    }

    public void getPromedioTotalOperadoCheque() {
        // TODO implement here
    }

    public List<Deuda> getDeudas() {
        return deudas;
    }

    public void setDeudas(List<Deuda> deudas) {
        this.deudas = deudas;
    }

    public LineaDeCredito getLineaCredito() {
        return lineaDeCredito;
    }

    public void setLineaCredito(LineaDeCredito lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }
}
