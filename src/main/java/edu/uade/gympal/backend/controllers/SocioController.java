package edu.uade.gympal.backend.controllers;

import edu.uade.gympal.backend.model.dto.EjercicioDto;
import edu.uade.gympal.backend.model.dto.RutinaDto;
import edu.uade.gympal.backend.model.dto.SocioDto;
import edu.uade.gympal.backend.model.Socio;

import java.time.DayOfWeek;
import java.util.List;

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

    public RutinaDto crearRutina(SocioDto socioDto, List<DayOfWeek> diasElegidos, List<EjercicioDto> ejercicioList) {
        //TODO usar EntrenamientoFactoryStrategy para traerme los List<EntrenamientoDia> y setearselo a la rutina.

        return new RutinaDto();
    }

}
