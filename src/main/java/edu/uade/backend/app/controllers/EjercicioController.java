package edu.uade.backend.app.controllers;

import edu.uade.backend.app.externalApis.externalEjercicios.EjercicioProviderAdapter;
import edu.uade.backend.app.externalApis.externalEjercicios.IEjercicioProviderAdapter;
import edu.uade.backend.app.model.dto.EjercicioDto;

import java.util.List;

public class EjercicioController {
    private final IEjercicioProviderAdapter ejercicioProviderAdapter = new EjercicioProviderAdapter();

    public List<EjercicioDto> fetchEjercicios() {
        return ejercicioProviderAdapter.fetchEjercicios();
    }
}
