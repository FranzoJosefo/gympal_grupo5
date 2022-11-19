package edu.uade.controllers;

import edu.uade.DTO.TablaComisionDto;
import edu.uade.enums.DataFilesNames;
import edu.uade.enums.SegmentoSocio;
import edu.uade.models.TablaComision;
import edu.uade.service.ApiService;

import java.util.ArrayList;
import java.util.List;

public enum ComisionController {
    INSTANCE;

    private List<TablaComision> tablasComision = new ArrayList<>();

    ComisionController() {
        tablasComision.addAll(getAllTablasComisionFromDataBase());
    }

    private List<TablaComision> getAllTablasComisionFromDataBase() {
        List<TablaComisionDto> tablasComisionDTO = ApiService.leer(TablaComisionDto.class, DataFilesNames.FILE_TABLAS_COMISION.getName());
        List<TablaComision> tablasComision = new ArrayList<>();
        for (TablaComisionDto currentTablaComisionDto : tablasComisionDTO) {
            tablasComision.add(new TablaComision(currentTablaComisionDto));
        }
        return tablasComision;
    }

    public void porcentajeComision() {
        // TODO Esto va ?
    }

    public void comisionABM() {
        // TODO Esto va ?
    }

    public void crearTablaComision() {
        // TODO Esto va ?
    }

    public TablaComision getTablaBySegmento(SegmentoSocio segmentoSocio) {
        TablaComision tablaComision = null;
        for (TablaComision currentTablaComision : tablasComision) {
            if (currentTablaComision.getSegmentoSocio() == segmentoSocio) {
                return tablaComision = currentTablaComision;
            }
        }
        System.out.println(tablasComision.toString());
        return tablasComision.get(0);
    }
}
