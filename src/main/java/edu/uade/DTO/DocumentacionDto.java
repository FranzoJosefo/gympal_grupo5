package edu.uade.DTO;

import edu.uade.enums.TipoDocumentacion;
import edu.uade.models.EstadosList;

import java.util.Date;

public class DocumentacionDto {

    private int documentacionId;
    private TipoDocumentacion tipoDocumentacion;
    private Date fechaRecepcion;
    private EstadosList estados;
    private boolean presentacionObligatoria;

    public DocumentacionDto(int documentacionId, TipoDocumentacion tipoDocumentacion, Date fechaRecepcion, EstadosList estados, boolean presentacionObligatoria) {
        this.documentacionId = documentacionId;
        this.tipoDocumentacion = tipoDocumentacion;
        this.fechaRecepcion = fechaRecepcion;
        this.estados = estados;
        this.presentacionObligatoria = presentacionObligatoria;
    }

    public int getDocumentacionId() {
        return documentacionId;
    }

    public TipoDocumentacion getTipoDocumentacion() {
        return tipoDocumentacion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public EstadosList getEstados() {
        return estados;
    }

    public boolean isPresentacionObligatoria() {
        return presentacionObligatoria;
    }
}