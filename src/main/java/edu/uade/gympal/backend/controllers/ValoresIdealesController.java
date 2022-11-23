package edu.uade.gympal.backend.controllers;

import edu.uade.gympal.backend.externalApis.valoresIdeales.ExternalValoresIdealesAdapter;
import edu.uade.gympal.backend.externalApis.valoresIdeales.IValoresIdealesAdapter;
import edu.uade.gympal.backend.model.dto.EstadoFisicoDto;

public class ValoresIdealesController {
    IValoresIdealesAdapter valoresIdealesAdapter = new ExternalValoresIdealesAdapter();

    public EstadoFisicoDto calcularEstadoFisicoIdeal(EstadoFisicoDto estadoFisicoActual) {
        return valoresIdealesAdapter.calcularEstadoFisicoIdeal(estadoFisicoActual);
    }
}
