package edu.uade.backend.app.externalApis.externalEjercicios;

import edu.uade.backend.app.model.dto.EjercicioDto;

import java.util.List;

public class EjercicioProviderAdapter implements IEjercicioProviderAdapter {

    @Override
    public List<EjercicioDto> fetchEjercicios() {
        return null; //TODO aca se deuvelve el mock que me pasa el pibe. Mocks.getSarasa()
    }
}
