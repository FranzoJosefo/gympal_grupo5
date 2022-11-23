package edu.uade.gympal.backend.externalApis.externalEjercicios;

import edu.uade.gympal.backend.model.dto.EjercicioDto;

import java.util.List;

public interface IEjercicioProviderAdapter {
    List<EjercicioDto> fetchEjercicios();
}
