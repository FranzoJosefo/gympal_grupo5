package edu.uade.backend.app.model;

import edu.uade.backend.app.model.dao.SocioDao;
import edu.uade.backend.app.model.dto.SocioDto;

public class Socio{

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
}
