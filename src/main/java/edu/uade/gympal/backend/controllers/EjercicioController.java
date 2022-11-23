package edu.uade.gympal.backend.controllers;

import edu.uade.gympal.backend.externalApis.externalEjercicios.EjercicioProviderAdapter;
import edu.uade.gympal.backend.externalApis.externalEjercicios.IEjercicioProviderAdapter;
import edu.uade.gympal.backend.model.dto.EjercicioDto;

import java.util.List;

public class EjercicioController {
    private final IEjercicioProviderAdapter ejercicioProviderAdapter = new EjercicioProviderAdapter();

    public List<EjercicioDto> fetchEjercicios() {
        return ejercicioProviderAdapter.fetchEjercicios();
    }
}
