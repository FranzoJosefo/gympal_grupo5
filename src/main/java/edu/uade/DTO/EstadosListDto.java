package edu.uade.DTO;

import java.util.List;

public class EstadosListDto {
    private List<EstadoDto> estados;

    public EstadosListDto(List<EstadoDto> estados) {
        this.estados = estados;
    }

    public List<EstadoDto> getEstados() {
        return this.estados;
    }

    public void agregarEstado(EstadoDto estado) {
        estados.add(estado);
    }
}
