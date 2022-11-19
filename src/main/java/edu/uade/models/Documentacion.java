package edu.uade.models;

import edu.uade.DTO.DocumentacionDto;
import edu.uade.enums.TipoDocumentacion;

import java.util.Date;

public class Documentacion {

    private int documentacionId;
    private TipoDocumentacion tipoDocumentacion;
    private Date fechaRecepcion;
    private EstadosList estados;
    private boolean presentacionObligatoria;

    public Documentacion(DocumentacionDto documentacionDTO) {
        this.documentacionId = documentacionDTO.getDocumentacionId();
        this.tipoDocumentacion = documentacionDTO.getTipoDocumentacion();
        this.fechaRecepcion = documentacionDTO.getFechaRecepcion();
        this.estados = documentacionDTO.getEstados();
        this.presentacionObligatoria = documentacionDTO.isPresentacionObligatoria();
    }

    public DocumentacionDto toDto() {
        return new DocumentacionDto(
                this.documentacionId,
                this.tipoDocumentacion,
                this.fechaRecepcion,
                this.estados,
                this.presentacionObligatoria);
    }
}