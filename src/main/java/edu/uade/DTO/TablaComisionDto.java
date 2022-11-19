package edu.uade.DTO;

import edu.uade.enums.SegmentoSocio;

public class TablaComisionDto {

    private int comisionTipo1;
    private int comisionTipo2;
    private int comisionTipo3;
    private SegmentoSocio segmentoSocio;
    private EstadosListDto estados;

    public TablaComisionDto(int comisionTipo1, int comisionTipo2, int comisionTipo3, SegmentoSocio segmentoSocio, EstadosListDto estados) {
        this.comisionTipo1 = comisionTipo1;
        this.comisionTipo2 = comisionTipo2;
        this.comisionTipo3 = comisionTipo3;
        this.segmentoSocio = segmentoSocio;
        this.estados = estados;
    }

    public int getComisionTipo1() {
        return comisionTipo1;
    }

    public int getComisionTipo2() {
        return comisionTipo2;
    }

    public int getComisionTipo3() {
        return comisionTipo3;
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
}