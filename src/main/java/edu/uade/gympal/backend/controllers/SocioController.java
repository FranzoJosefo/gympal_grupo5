package edu.uade.gympal.backend.controllers;

import edu.uade.gympal.backend.model.Ejercicio;
import edu.uade.gympal.backend.model.EntrenamientoDia;
import edu.uade.gympal.backend.model.dto.EjercicioDto;
import edu.uade.gympal.backend.model.dto.ObjetivoDto;
import edu.uade.gympal.backend.model.dto.RutinaDto;
import edu.uade.gympal.backend.model.dto.SocioDto;
import edu.uade.gympal.backend.model.Socio;
import edu.uade.gympal.backend.model.factory.EntrenamientoStrategyFactory;

import java.time.DayOfWeek;
import java.util.List;

public class SocioController {

    private Socio socio;

    public SocioController() {
        socio = new Socio();
    }

    private EntrenamientoStrategyFactory entrenamientoStrategyFactory = new EntrenamientoStrategyFactory();

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
        RutinaDto rutinaDto = new RutinaDto();
        ObjetivoDto objetivoDto = socioDto.getObjetivo();
        List<EntrenamientoDia> diasEntrenamiento = entrenamientoStrategyFactory.getEntrenamientoStrategy(objetivoDto.getObjetivoTipo()).getEntrenamientos(diasElegidos, Ejercicio.ejerciciosDtoToEjercicios(ejercicioList));
        rutinaDto.setEntrenamientos(EntrenamientoDia.convertEntrenamientoDiaListToDto(diasEntrenamiento));
        return rutinaDto;
    }

}
