package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dao.SocioDao;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.backend.app.model.enums.Sexo;

public class Socio{

    String usuario;
    Objetivo objetivo;
    int edad;
    EstadoFisico estadoFisico;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EstadoFisico getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(EstadoFisico estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public void registrarSocio(SocioDto socioDto) {
        SocioDao.registrarSocio(socioDto);
    }

    public void modificarSocio(SocioDto socioDto) {
        SocioDao.modificarSocio(socioDto);
    }

    public void eliminarSocio(SocioDto socioDto) {
        SocioDao.eliminarSocio(socioDto);
    }

    public SocioDto getSocioByName(String userName) {
        return SocioDao.getSocioByUserName(userName);
    }

    private Boolean isSocioValid(SocioDto socioDto) {
        return true;
    }

    public SocioDto toDto() {
        SocioDto dto = new SocioDto();
        dto.setEstadoFisico(getEstadoFisico().toDto());
        dto.setEdad(getEdad());
        dto.setUsuario(getUsuario());
        dto.setObjetivo(getObjetivo().toDto());
        return dto;
    }

}
