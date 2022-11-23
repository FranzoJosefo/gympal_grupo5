package edu.uade.backend.app.controllers;

import edu.uade.backend.app.model.Rutina;
import edu.uade.backend.app.model.dto.ObjetivoDto;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.backend.app.model.Socio;

public class SocioController {

    private Socio socio;

    public SocioController() {
        socio = new Socio();
    }

    public Socio getSocio() {
        return socio;
    }

//////////////////////////////////////////////////////////

    /**
     * CRUD Methods
     */

    public void registrarSocio(SocioDto socioDto) {
        socio.registrarSocio(socioDto);
    }

    public SocioDto buscarSocio(String userName) {
        return socio.getSocioByName(userName);
    }

    public void modificarSocio(SocioDto socioDto) {
        socio.modificarSocio(socioDto);
    }

    public void eliminarSocio(SocioDto socioDto) {
        socio.eliminarSocio(socioDto);
    }

    private Rutina crearRutina() {
        return new Rutina();
    }

}
