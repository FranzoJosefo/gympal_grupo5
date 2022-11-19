package edu.uade.models;

import edu.uade.DTO.AporteDto;
import edu.uade.DTO.SocioProtectorDto;
import edu.uade.enums.SegmentoSocio;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static edu.uade.utils.Utils.createAportesFromDto;

public class SocioProtector extends SocioEmpresa {

    private List<Aporte> aportes;

    public SocioProtector(SocioProtectorDto socioProtectorDto) {

        super(socioProtectorDto.getSocioId(),
                socioProtectorDto.getCuit(),
                socioProtectorDto.getRazonSocial(),
                socioProtectorDto.getFecha(),
                socioProtectorDto.getTamanioEmpresa(),
                socioProtectorDto.getActividadPrincipal(),
                socioProtectorDto.getDireccion(),
                socioProtectorDto.getTelefono(),
                socioProtectorDto.getMail(),
                socioProtectorDto.getPostulante(),
                Utils.createAccionesFromDto(socioProtectorDto.getAcciones()),
                Utils.createAccionistasFromDto(socioProtectorDto.getAccionistas()),
                socioProtectorDto.getSegmentoSocio(),
                new EstadosList(socioProtectorDto.getEstados()));
        this.aportes = createAportesFromDto(socioProtectorDto.getAportes());
    }

    public List<Aporte> getAportes() {
        return aportes;
    }

    public List<AporteDto> aportesToDto() {
        List<AporteDto> aporteDTOS = new ArrayList<>();
        for (Aporte currentAporte : this.aportes) {
            aporteDTOS.add(currentAporte.toDto());
        }
        return aporteDTOS;
    }

    public void setAportes(List<Aporte> aportes) {
        this.aportes = aportes;
    }

    public SocioProtectorDto toDto() {
        return new SocioProtectorDto(getSocioId(),
                getCuit(),
                getRazonSocial(),
                getFecha(),
                getTamanioEmpresa(),
                getActividadPrincipal(),
                getDireccion(),
                getTelefono(),
                getMail(),
                getPostulante(),
                getAccionesToDto(),
                accionistasToDto(),
                getSegmentoSocio(),
                getEstados().toDto(),
                aportesToDto());
    }
}