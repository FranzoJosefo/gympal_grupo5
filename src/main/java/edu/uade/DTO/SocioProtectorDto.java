package edu.uade.DTO;

import edu.uade.enums.SegmentoSocio;
import edu.uade.enums.TamanioEmpresa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SocioProtectorDto {

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
    private List<AccionDto> acciones;
    private List<AccionistaDto> accionistas;
    private SegmentoSocio segmentoSocio;
    private EstadosListDto estados = new EstadosListDto(new ArrayList<>());
//socio procetcor
    private List<AporteDto> aportes;

    public SocioProtectorDto(int socioId, String cuit, String razonSocial, Date fecha, TamanioEmpresa tamanioEmpresa,
                             String actividadPrincipal, String direccion, String telefono, String mail, String postulante,
                             List<AccionDto> acciones, List<AccionistaDto> accionistas, SegmentoSocio segmentoSocio,
                             EstadosListDto estados, List<AporteDto> aportes) {
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
        this.acciones = acciones;
        this.accionistas = accionistas;
        this.segmentoSocio = segmentoSocio;
        this.estados = estados;
        this.aportes = aportes;
    }
    public SocioProtectorDto() {

    }

    public int getSocioId() {
        return socioId;
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Date getFecha() {
        return fecha;
    }

    public TamanioEmpresa getTamanioEmpresa() {
        return tamanioEmpresa;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public String getPostulante() {
        return postulante;
    }

    public List<AccionDto> getAcciones() {
        return acciones;
    }

    public List<AccionistaDto> getAccionistas() {
        return accionistas;
    }

    public SegmentoSocio getSegmentoSocio() {
        return segmentoSocio;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public List<AporteDto> getAportes() {return aportes;}

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTamanioEmpresa(TamanioEmpresa tamanioEmpresa) {
        this.tamanioEmpresa = tamanioEmpresa;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPostulante(String postulante) {
        this.postulante = postulante;
    }

    public void setAcciones(List<AccionDto> acciones) {
        this.acciones = acciones;
    }

    public void setAccionistas(List<AccionistaDto> accionistas) {
        this.accionistas = accionistas;
    }

    public void setSegmentoSocio(SegmentoSocio segmentoSocio) {
        this.segmentoSocio = segmentoSocio;
    }

    public void setEstados(EstadosListDto estados) {
        this.estados = estados;
    }

    public void setAportes(List<AporteDto> aportes) {
        this.aportes = aportes;
    }
}
