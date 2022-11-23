package edu.uade.gympal.backend.externalApis.externalEjercicios;

import edu.uade.gympal.backend.mock.EntitiesMocks;
import edu.uade.gympal.backend.model.dto.EjercicioDto;

import java.util.List;

public class EjercicioProviderAdapter implements IEjercicioProviderAdapter {

    @Override
    public List<EjercicioDto> fetchEjercicios() {
        return EntitiesMocks.getEjercicioDtoMock(); //Aca iria el servicio Externo de Ejercicios. API.
    }
}
