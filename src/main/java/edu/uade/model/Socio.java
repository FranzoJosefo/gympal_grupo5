package edu.uade.model;

import edu.uade.model.dao.SocioDao;
import edu.uade.model.dto.SocioDto;

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
