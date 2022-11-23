package edu.uade.backend.app.externalApis.valoresIdeales;

import edu.uade.backend.app.model.dto.EstadoFisicoDto;

public interface IValoresIdealesAdapter {
    EstadoFisicoDto calcularEstadoFisicoIdeal(EstadoFisicoDto estadoActual);
}
