package edu.uade.backend.app.controllers;

import edu.uade.backend.app.model.dto.ObjetivoDto;
import edu.uade.backend.app.model.dto.SocioDto;
import edu.uade.backend.app.model.Socio;

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

    public void crearObjetivo(ObjetivoDto objetivoDto) {

    }

}
