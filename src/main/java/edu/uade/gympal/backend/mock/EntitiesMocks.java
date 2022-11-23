package edu.uade.gympal.backend.mock;

import edu.uade.gympal.backend.model.EstadoFisico;
import edu.uade.gympal.backend.model.dto.EjercicioDto;
import edu.uade.gympal.backend.model.dto.NivelAerobicoDto;
import edu.uade.gympal.backend.model.enums.ExigenciaMuscular;
import edu.uade.gympal.backend.model.enums.GrupoMuscular;
import edu.uade.gympal.backend.model.enums.Sexo;

import java.util.ArrayList;
import java.util.List;

public class EntitiesMocks {

    public static List<EjercicioDto> getEjercicioDtoMock() {
        int recordsQty = 5;
        List<EjercicioDto> EjercicioDtosMockList = new ArrayList<>();

        List<NivelAerobicoDto> nivelAerobico = getNivelAerobicoMock(new int[] {1, 2, 8, 4, 5});
        ExigenciaMuscular[] exigenciaMuscular = getExigenciaMuscularMock();
        GrupoMuscular[] grupoMuscular = getGrupoMuscularMock();
        int[] cantidadSeries             = {3, 3, 3, 4, 4};
        int[] cantidadRepeticiones       = {6, 12, 20, 8, 12};
        int[] duracionRepeticionSegundos = {10, 3, 2, 5, 3};
        Float[] pesoAsignado             = {(float)60, (float)20, (float)2, (float)12, (float)12};

        for(int i=0; i < recordsQty; i++) {
            EjercicioDto newEjercicioDto = new EjercicioDto();
            newEjercicioDto.setNivelAerobico(nivelAerobico.get(i));
            newEjercicioDto.setGrupoMuscular(grupoMuscular[i]);
            newEjercicioDto.setExigenciaMuscular(exigenciaMuscular[i]);
            newEjercicioDto.setCantidadSeries(cantidadSeries[i]);
            newEjercicioDto.setCantidadRepeticiones(cantidadRepeticiones[i]);
            newEjercicioDto.setDuracionRepeticionSegundos(duracionRepeticionSegundos[i]);
            newEjercicioDto.setPesoAsignado(pesoAsignado[i]);

            EjercicioDtosMockList.add(newEjercicioDto);
        }

        return EjercicioDtosMockList;
    }

    private static ExigenciaMuscular[] getExigenciaMuscularMock() {
        ExigenciaMuscular[] mockArray = {
                ExigenciaMuscular.ALTA,
                ExigenciaMuscular.ALTA,
                ExigenciaMuscular.BAJA,
                ExigenciaMuscular.MEDIA,
                ExigenciaMuscular.MEDIA
        };
        return mockArray;
    }

    private static GrupoMuscular[] getGrupoMuscularMock() {
        return new GrupoMuscular[]{
                GrupoMuscular.BRAZOS,
                GrupoMuscular.ESPALDA,
                GrupoMuscular.PIERNAS,
                GrupoMuscular.BRAZOS,
                GrupoMuscular.PIERNAS
        };
    }

    private static List<NivelAerobicoDto> getNivelAerobicoMock(int[] niveles) {
        List<NivelAerobicoDto> mockList = new ArrayList<>();

        for (int nivele : niveles) {
            NivelAerobicoDto newNA = new NivelAerobicoDto();
            newNA.setNivel(nivele);
            mockList.add(newNA);
        }

        return mockList;
    }

    public static List<EstadoFisico> getEstadoFisicoValoresIdealesMock() {
        List<EstadoFisico> estadoFisicoMockList = new ArrayList<>();

	    float[] peso = {(float)75.2, (float)84.6, (float)67.8, (float)62, (float)101.3};
        float[] masaMuscular = {(float)60, (float)20, (float)2, (float)12, (float)12};//faltan valores que sirvan
        float[] grasaCorporal = {(float)60, (float)20, (float)2, (float)12, (float)12};//faltan valores que sirvan
//	    float[] altura = {(float)1.66, (float)1.83, (float)1.57, (float)1.74, (float)1.87};


        estadoFisicoMockList = buildMockList(peso, masaMuscular, grasaCorporal);

        return estadoFisicoMockList;
    }

    private static List<EstadoFisico> buildMockList(float[] pesos, float[] masaMusculares, float[] grasaCorporales) {
        List<EstadoFisico> mockList = new ArrayList<>();
        Sexo newEFSexo;
        for(int i=0; i < pesos.length; i++) {
            newEFSexo = (i/2 > 2) ? Sexo.F : Sexo.M; //fruta

            EstadoFisico newEF = new EstadoFisico();
            newEF.setPeso(pesos[i]);
            newEF.setMasaMuscular(masaMusculares[i]);
            newEF.setGrasaCorporal(grasaCorporales[i]);
            newEF.setSexo(newEFSexo);

            mockList.add(newEF);
        }
        return mockList;
    }

}