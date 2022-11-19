package edu.uade.DTO;

import edu.uade.enums.TipoAccionista;
import edu.uade.models.Accionista;

import java.util.ArrayList;
import java.util.List;

public class AccionistaDto {

    private int accionistaId;
    private String cuit;
    private String razonSocial;
    private double participacionPorcentaje;
    private TipoAccionista tipoAccionista;

    public AccionistaDto(int accionistaId, String cuit, String razonSocial,
                         double participacionPorcentaje, TipoAccionista tipoAccionista) {
        this.accionistaId = accionistaId;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.participacionPorcentaje = participacionPorcentaje;
        this.tipoAccionista = tipoAccionista;
    }

    public List<Accionista> createAccionistas(List<AccionistaDto> accionistaDtos) {
        List<Accionista> accionistas = new ArrayList<>();
        for (AccionistaDto currentAccionistaDto : accionistaDtos) {
            accionistas.add(new Accionista(currentAccionistaDto));
        }
        return accionistas;
    }

    public int getAccionistaId() {
        return accionistaId;
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public double getParticipacionPorcentaje() {
        return participacionPorcentaje;
    }

    public TipoAccionista getTipoAccionista() {
        return tipoAccionista;
    }
}