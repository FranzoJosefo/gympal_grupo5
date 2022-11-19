package edu.uade.models;

import edu.uade.DTO.EstadoDto;
import edu.uade.DTO.EstadosListDto;
import edu.uade.utils.Utils;

import java.util.*;

/**
 * 
 */
public class EstadosList {

    private List<Estado> estados = new ArrayList<>();
    //private String estadoAnterior;
    //private String estadoActual;

    public EstadosList(){

    }

    public EstadosList(EstadosListDto estadosListDto) {
        this.estados = Utils.createEstadosFromDto(estadosListDto.getEstados());
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public EstadosListDto toDto(){
        List <EstadoDto> estadoDtoList = new ArrayList<>();
        for( Estado estado : this.getEstados()) {
            estadoDtoList.add(estado.toDto());
        }
        return new EstadosListDto(estadoDtoList);
    }
    public void setEstados(List<Estado> EstadoDto) {
        this.estados = estados;
    }

    public void agregarEstado(Estado estado) {
        this.estados.add(estado);
    }

}