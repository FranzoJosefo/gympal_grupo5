package edu.uade.backend.app.externalApis.externalEjercicios;

import edu.uade.backend.app.model.dto.EjercicioDto;

import java.util.List;

public interface IEjercicioProviderAdapter {
    List<EjercicioDto> fetchEjercicios();
}
