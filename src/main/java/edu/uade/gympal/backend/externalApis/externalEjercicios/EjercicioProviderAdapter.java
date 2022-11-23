package edu.uade.gympal.backend.externalApis.externalEjercicios;

import edu.uade.gympal.backend.model.dto.EjercicioDto;

import java.util.List;

public class EjercicioProviderAdapter implements IEjercicioProviderAdapter {

    @Override
    public List<EjercicioDto> fetchEjercicios() {
        //TODO aca se deuvelve el mock que me pasa el pibe. Mocks.getSarasa()
        return null;
    }
}
