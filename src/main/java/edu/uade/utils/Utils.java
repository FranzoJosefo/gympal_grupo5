package edu.uade.utils;

import edu.uade.DTO.*;
import edu.uade.models.*;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Accionista> createAccionistasFromDto(List<AccionistaDto> accionistaDtos) {
        List<Accionista> accionistas = new ArrayList<>();
        if (accionistaDtos != null) {
            for (AccionistaDto currentAccionistaDto : accionistaDtos) {
                accionistas.add(new Accionista(currentAccionistaDto));
            }
        }
        return accionistas;
    }

    public static List<Accion> createAccionesFromDto(List<AccionDto> accionDTOS) {
        List<Accion> acciones = new ArrayList<>();
        if (accionDTOS != null) {
            for (AccionDto currentAccionDto : accionDTOS) {
                acciones.add(new Accion(currentAccionDto));
            }
        }
        return acciones;
    }

    public static List<Aporte> createAportesFromDto(List<AporteDto> aporteDTOS) {
        List<Aporte> aportes = new ArrayList<>();
        if (aporteDTOS != null) {
            for (AporteDto currentAporteDto : aporteDTOS) {
                aportes.add(new Aporte(currentAporteDto));
            }
        }
        return aportes;
    }

    public static List<Deuda> createDeudasFromDto(List<DeudaDto> deudasDTOS) {
        List<Deuda> deudas = new ArrayList<>();
        if (deudasDTOS != null) {
            for (DeudaDto currentDeudaDto : deudasDTOS) {
                deudas.add(new Deuda(currentDeudaDto));
            }
        }
        return deudas;
    }

    public static List<Estado> createEstadosFromDto(List <EstadoDto> estadoDtoList) {
        List <Estado> estadosList = new ArrayList<>();
        if (estadoDtoList != null) {
            for (EstadoDto currentEstadoDto : estadoDtoList) {
                estadosList.add(new Estado(currentEstadoDto));
            }
        }
        return estadosList;
    }
}
