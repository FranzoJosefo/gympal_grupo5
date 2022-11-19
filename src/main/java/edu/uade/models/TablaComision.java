package edu.uade.models;

import edu.uade.DTO.EstadosListDto;
import edu.uade.DTO.TablaComisionDto;
import edu.uade.enums.SegmentoSocio;
import edu.uade.enums.TipoOperacion;

public class TablaComision {

    private double comisionTipo1;
    private double comisionTipo2;
    private double comisionTipo3;
    private EstadosListDto estados;
    private SegmentoSocio segmentoSocio;

    public TablaComision(TablaComisionDto tablaComisionDTO) {
        this.comisionTipo1 = tablaComisionDTO.getComisionTipo1();
        this.comisionTipo2 = tablaComisionDTO.getComisionTipo2();
        this.comisionTipo3 = tablaComisionDTO.getComisionTipo3();
        this.segmentoSocio = tablaComisionDTO.getSegmentoSocio();
        this.estados = tablaComisionDTO.getEstados();
    }

    public double getComisionByTipoOperacion(TipoOperacion tipoOperacion) throws IllegalArgumentException {
        switch (tipoOperacion) {
            case CHEQUE_PAGARE: return comisionTipo1;
            case CCC_TC: return comisionTipo2;
            case PRESTAMOS: return comisionTipo3;
            default: throw new IllegalArgumentException("TipoOperacion invalido");
        }
    }

    public double getComisionTipo1() {
        return comisionTipo1;
    }

    public void setComisionTipo1(double comisionTipo1) {
        this.comisionTipo1 = comisionTipo1;
    }

    public double getComisionTipo2() {
        return comisionTipo2;
    }

    public void setComisionTipo2(double comisionTipo2) {
        this.comisionTipo2 = comisionTipo2;
    }

    public double getComisionTipo3() {
        return comisionTipo3;
    }

    public void setComisionTipo3(double comisionTipo3) {
        this.comisionTipo3 = comisionTipo3;
    }

    public EstadosListDto getEstados() {
        return estados;
    }

    public void setEstados(EstadosListDto estados) {
        this.estados = estados;
    }

    public SegmentoSocio getSegmentoSocio() {
        return segmentoSocio;
    }

    public void setSegmentoSocio(SegmentoSocio segmentoSocio) {
        this.segmentoSocio = segmentoSocio;
    }
}