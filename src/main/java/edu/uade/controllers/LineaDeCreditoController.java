package edu.uade.controllers;

import edu.uade.DTO.LineaDeCreditoDto;
import edu.uade.enums.DataFilesNames;
import edu.uade.models.LineaDeCredito;
import edu.uade.service.ApiService;

import java.util.ArrayList;
import java.util.List;

public enum LineaDeCreditoController {
    INSTANCE;

    private List<LineaDeCredito> lineasDeCredito = new ArrayList<>();

    LineaDeCreditoController() {
        lineasDeCredito.addAll(getAllLineasDeCreditoFromDataBase());
    }

    private List<LineaDeCredito> getAllLineasDeCreditoFromDataBase() {
        List<LineaDeCreditoDto> dtos = ApiService.leer(LineaDeCreditoDto.class, DataFilesNames.FILE_LINEAS_DE_CREDITO.getName());
        List<LineaDeCredito> lineasDeCredito = new ArrayList<>();
        for (LineaDeCreditoDto dto : dtos) {
            lineasDeCredito.add(new LineaDeCredito(dto));
        }
        return lineasDeCredito;
    }

    public void lineaDeCreditosABM() {
        // TODO implement here
    }
}