package edu.uade.backend.app.controllers;

import edu.uade.backend.app.externalApis.valoresIdeales.ExternalValoresIdealesAdapter;
import edu.uade.backend.app.externalApis.valoresIdeales.IValoresIdealesAdapter;
import edu.uade.backend.app.model.dto.EstadoFisicoDto;

public class ValoresIdealesController {
    IValoresIdealesAdapter valoresIdealesAdapter = new ExternalValoresIdealesAdapter();

    public EstadoFisicoDto calcularEstadoFisicoIdeal(EstadoFisicoDto estadoFisicoActual) {
        return valoresIdealesAdapter.calcularEstadoFisicoIdeal(estadoFisicoActual);
    }
}
