package edu.uade.controllers;

import edu.uade.db.SocioDb;
import edu.uade.model.Socio;
import edu.uade.model.dto.SocioDto;

public class SocioController {

    private Socio socio;

    public SocioController() {
        socio = new Socio();
    }
 //View de Didi
//    public VentanaPrincipal getMiVentanaPrincipal() {
//        return miVentanaPrincipal;
//    }


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

}
