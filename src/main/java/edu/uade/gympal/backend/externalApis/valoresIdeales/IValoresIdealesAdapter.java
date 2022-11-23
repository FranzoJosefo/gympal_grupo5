package edu.uade.gympal.backend.externalApis.valoresIdeales;

import edu.uade.gympal.backend.model.dto.EstadoFisicoDto;

public interface IValoresIdealesAdapter {
    EstadoFisicoDto calcularEstadoFisicoIdeal(EstadoFisicoDto estadoActual);
}
