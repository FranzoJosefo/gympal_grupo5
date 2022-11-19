package edu.uade.models;

import edu.uade.DTO.EstadoDto;

import java.util.*;

public class Estado {

    private Date fecha;
    private String nombre;

    public Estado(EstadoDto estadoDto) {
        this.fecha = estadoDto.getFecha();
        this.nombre = estadoDto.getNombre();
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoDto toDto () {
        return new EstadoDto(getFecha(), getNombre());
    }
}