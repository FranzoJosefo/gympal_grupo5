package edu.uade.DTO;

import java.util.Date;

public class EstadoDto {
    private Date fecha;
    private String nombre;

    public EstadoDto(Date fecha, String nombre) {
        this.fecha=fecha;
        this.nombre=nombre;
    }

        public Date getFecha() {
            return fecha;
        }
        public String getNombre() {
            return nombre;
        }

    }
