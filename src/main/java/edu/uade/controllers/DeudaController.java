package edu.uade.controllers;

import edu.uade.DTO.DeudaDto;
import edu.uade.enums.DataFilesNames;
import edu.uade.models.Deuda;
import edu.uade.models.SocioEmpresa;
import edu.uade.models.SocioParticipe;
import edu.uade.service.ApiService;

import java.util.ArrayList;
import java.util.List;

public enum DeudaController {
    INSTANCE;

    private List<Deuda> deudas = new ArrayList<>();

    DeudaController() {
        deudas.addAll(getAllLineasDeCreditoFromDataBase());
    }

    private List<Deuda> getAllLineasDeCreditoFromDataBase() {
        List<DeudaDto> dtos = ApiService.leer(DeudaDto.class, DataFilesNames.FILE_DEUDAS.getName());
        List<Deuda> deudas = new ArrayList<>();
        for (DeudaDto dto : dtos) {
            deudas.add(new Deuda(dto));
        }
        return deudas;
    }

    public void generarDeuda() {
        // TODO implement here
    }

    public void getDeudaByDia() {
        // TODO implement here
    }

    public double getMoraTotal(int socioid) {
        double mora = 0;
        for (SocioEmpresa socio : SocioController.INSTANCE.getSocios()) {
            if (socio.getSocioId() == (socioid) && socio instanceof SocioParticipe) {
                for (Deuda deuda : ((SocioParticipe) socio).getDeudas()) {
                    mora += deuda.getMontoMora();
                }
            }
        }
        return mora;
    }

    public List<DeudaDto> deudasToDto(List<Deuda> deudas) {
        List<DeudaDto> deudasDtos = new ArrayList<>();
        for (Deuda currentDeuda : deudas) {
            deudasDtos.add(currentDeuda.toDto());
        }
        return deudasDtos;
    }
}
