package edu.uade.models;

import edu.uade.DTO.AccionDto;
import edu.uade.DTO.AccionistaDto;
import edu.uade.DTO.DeudaDto;
import edu.uade.enums.SegmentoSocio;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.enums.TipoAccionista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class SocioEmpresa {

    private int socioId;
    private String cuit;
    private String razonSocial;
    private Date fecha;
    private TamanioEmpresa tamanioEmpresa;
    private String actividadPrincipal;
    private String direccion;
    private String telefono;
    private String mail;
    private String postulante;
    private List<Accion> acciones;
    private List<Accionista> accionistas;
    private SegmentoSocio segmentoSocio;
    private EstadosList estados;

    public SocioEmpresa(int socioId, String cuit, String razonSocial, Date fecha, TamanioEmpresa tamanioEmpresa,
                        String actividadPrincipal, String direccion, String telefono, String mail, String postulante,
                        List<Accion> acciones, List<Accionista> accionistas, SegmentoSocio segmentoSocio,
                        EstadosList estados) {
        this.socioId = socioId;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fecha = fecha;
        this.tamanioEmpresa = tamanioEmpresa;
        this.actividadPrincipal = actividadPrincipal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.postulante = postulante;
        this.acciones = new ArrayList<>();
        this.acciones = acciones;
        this.accionistas = new ArrayList<>();
        this.accionistas = accionistas;
        this.segmentoSocio = segmentoSocio;
        this.estados = estados;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TamanioEmpresa getTamanioEmpresa() {
        return tamanioEmpresa;
    }

    public void setTamanioEmpresa(TamanioEmpresa tamanioEmpresa) {
        this.tamanioEmpresa = tamanioEmpresa;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPostulante() {
        return postulante;
    }

    public void setPostulante(String postulante) {
        this.postulante = postulante;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public List<AccionDto> getAccionesToDto() {
        List<AccionDto> accionesDtos = new ArrayList<>();
        for (Accion currentAccion : this.acciones) {
            accionesDtos.add(currentAccion.toDto());
        }
        return accionesDtos;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public List<Accionista> getAccionistas() {
        return accionistas;
    }

    public List<AccionistaDto> accionistasToDto() {
        List<AccionistaDto> accionistasDtos = new ArrayList<>();
        for (Accionista currentAccionista : this.accionistas) {
            accionistasDtos.add(currentAccionista.toDto());
        }
        return accionistasDtos;
    }

    public void setAccionistas(List<Accionista> accionistas) {
        this.accionistas = accionistas;
    }

    public SegmentoSocio getSegmentoSocio() {
        return segmentoSocio;
    }

    public void setSegmentoSocio(SegmentoSocio segmentoSocio) {
        this.segmentoSocio = segmentoSocio;
    }

    public EstadosList getEstados() {
        return estados;
    }

    public void setEstados(EstadosList estados) {
        this.estados = estados;
    }

    public void agregarAccionista(int accionistaId, String cuit, String razonSocial,
                                  float participacionPorcentaje, TipoAccionista tipoAccionista) {

        Accionista accionista = new Accionista(new AccionistaDto(accionistaId, cuit, razonSocial, participacionPorcentaje, tipoAccionista));

        this.accionistas.add(accionista);
    }
}
