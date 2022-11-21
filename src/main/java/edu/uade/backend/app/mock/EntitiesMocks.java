//package edu.uade.backend.app.mock;
//
//import edu.uade.DTO.*;
//import edu.uade.enums.*;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class EntitiesMocks {
//
//    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//    public static List<SocioParticipeDto> getSociosMock() {
//
//        List<SocioParticipeDto> socioParticipes = new ArrayList<>();
//        List<DeudaDto> deudas = getDeudasMock();
//        List<AccionDto> acciones = getAccionesMock();
//        List<AccionistaDto> accionistas = getAccionistasMock();
//        List<LineaDeCreditoDto> lineasDeCredito = getLineasDeCreditoMock();
//        EstadosListDto estadoListSocio = new EstadosListDto(new ArrayList<>());
//
//        try {
//            estadoListSocio.agregarEstado(new EstadoDto(sdf.parse("01/01/2020"), SocioEstado.INGRESADO.toString()));
//            estadoListSocio.agregarEstado(new EstadoDto(sdf.parse("01/01/2020"), SocioEstado.CONTROLADO.toString()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        // SOCIO 1
//        socioParticipes.add(new SocioParticipeDto(1, "30-111111-1", "GOOGLE", new Date(),
//                TamanioEmpresa.GRANDE, "Software", "Calle Falsa 4727",
//                "55551234", "google@google.com", "Pleno",
//                acciones.subList(0, 1), accionistas.subList(0, 1), SegmentoSocio.PLATINO, estadoListSocio,
//                deudas.subList(0, 1), lineasDeCredito.get(0)));
//
//        // SOCIO 2
//        socioParticipes.add(new SocioParticipeDto(2, "30-222222-2", "INTEL", new Date(),
//                TamanioEmpresa.GRANDE, "Tostadoras", "Calle Falsa 9146",
//                "55559876", "intel@intel.com", "Pleno",
//                acciones.subList(1, 2), accionistas.subList(1, 2), SegmentoSocio.NORMAL, estadoListSocio,
//                deudas.subList(1, 2), lineasDeCredito.get(1)));
//
//        // SOCIO 3
//        socioParticipes.add(new SocioParticipeDto(3, "30-333333-3", "AMD", new Date(),
//                TamanioEmpresa.GRANDE, "Procesadores", "Calle Falsa 1234",
//                "55559876", "amd@intel.com", "Pleno",
//                acciones.subList(2, 3), accionistas.subList(2, 3), SegmentoSocio.NORMAL, estadoListSocio,
//                deudas.subList(2, 3), lineasDeCredito.get(2)));
//
//        // SOCIO 4
//        socioParticipes.add(new SocioParticipeDto(4, "30-444444-4", "APPLE", new Date(),
//                TamanioEmpresa.GRANDE, "Trash", "Calle Falsa 4321",
//                "55559876", "apple@apple.com", "Pleno",
//                acciones.subList(3, 4), accionistas.subList(3, 4), SegmentoSocio.ORO, estadoListSocio,
//                deudas.subList(3, 4), lineasDeCredito.get(3)));
//
//        // SOCIO 5
//        socioParticipes.add(new SocioParticipeDto(5, "30-555555-5", "MOTOROLA", new Date(),
//                TamanioEmpresa.GRANDE, "Bricks", "Calle Falsa 1463",
//                "55559876", "motorola@motorola.com", "Pleno",
//                acciones.subList(4, 5), accionistas.subList(4, 5), SegmentoSocio.ORO, estadoListSocio,
//                deudas.subList(4, 5), lineasDeCredito.get(4)));
//
//        // SOCIO 6
//        socioParticipes.add(new SocioParticipeDto(6, "30-666666-6", "XIAOMI", new Date(),
//                TamanioEmpresa.GRANDE, "WorldConquer", "Calle Falsa 1456",
//                "55559876", "xiaomi@xiaomi.com", "Pleno",
//                acciones.subList(5, 6), accionistas.subList(5, 6), SegmentoSocio.NORMAL, estadoListSocio,
//                deudas.subList(5, 6), lineasDeCredito.get(5)));
//
//        // SOCIO 7
//        socioParticipes.add(new SocioParticipeDto(7, "30-777777-7", "GUAYMALLEN", new Date(),
//                TamanioEmpresa.PEQUEÑA, "AlfajoresPaa", "Calle Falsa 1928",
//                "55559876", "guaymallen@guaymallen.com", "Pleno",
//                acciones.subList(6, 7), accionistas.subList(6, 7), SegmentoSocio.NORMAL, estadoListSocio,
//                deudas.subList(6, 7), lineasDeCredito.get(6)));
//
//        // SOCIO 8
//        socioParticipes.add(new SocioParticipeDto(8, "30-888888-8", "CAPITAN DEL ESPACIO", new Date(),
//                TamanioEmpresa.GRANDE, "AlfajoresPaa++", "Calle Falsa 1276",
//                "55559876", "capitandelespacio@capitandelespacio.com", "Pleno",
//                acciones.subList(7, 8), accionistas.subList(7, 8), SegmentoSocio.BRONCE, estadoListSocio,
//                deudas.subList(7, 8), lineasDeCredito.get(7)));
//
//        // SOCIO 9
//        socioParticipes.add(new SocioParticipeDto(9, "30-999999-9", "HAVANNA", new Date(),
//                TamanioEmpresa.MEDIANA, "AlfajoresChetos", "Calle Falsa 8765",
//                "55559876", "havanna@havanna.com", "Pleno",
//                acciones.subList(8, 9), accionistas.subList(8, 9), SegmentoSocio.ORO, estadoListSocio,
//                deudas.subList(8, 9), lineasDeCredito.get(8)));
//
//        // SOCIO 10
//        socioParticipes.add(new SocioParticipeDto(10, "31-000000-0", "MANAOS", new Date(),
//                TamanioEmpresa.GRANDE, "Muerte", "Calle Falsa 2742",
//                "55559876", "manaos@manaos.com", "Pleno",
//                acciones.subList(9, 10), accionistas.subList(9, 10), SegmentoSocio.PLATINO, estadoListSocio,
//                deudas.subList(9, 10), lineasDeCredito.get(9)));
//        return socioParticipes;
//    }
//
//    public static List<TablaComisionDto> getTablasComisionMock() {
//        List<TablaComisionDto> tablasComisionDTOList = new ArrayList<>();
//        tablasComisionDTOList.add(new TablaComisionDto(5, 5, 4, SegmentoSocio.NORMAL, new EstadosListDto(null)));
//        tablasComisionDTOList.add(new TablaComisionDto(4, 4, 3, SegmentoSocio.BRONCE, new EstadosListDto(null)));
//        tablasComisionDTOList.add(new TablaComisionDto(3, 3, 2, SegmentoSocio.ORO, new EstadosListDto(null)));
//        tablasComisionDTOList.add(new TablaComisionDto(2, 2, 1, SegmentoSocio.PLATINO, new EstadosListDto(null)));
//        return tablasComisionDTOList;
//    }
//
//    public static List<DeudaDto> getDeudasMock() {
//        List<DeudaDto> deudas = new ArrayList<>();
//        try {
//            deudas.add(new DeudaDto(1, new EstadosListDto(null), 1001, 1, 10, sdf.parse("12/01/2021"), TipoOperacion.CHEQUE_PAGARE));
//            deudas.add(new DeudaDto(2, new EstadosListDto(null), 1001, 2, 8, sdf.parse("14/02/2021"), TipoOperacion.CCC_TC));
//            deudas.add(new DeudaDto(3, new EstadosListDto(null), 10, 3, 10, sdf.parse("01/03/2021"), TipoOperacion.PRESTAMOS));
//            deudas.add(new DeudaDto(4, new EstadosListDto(null), 10, 4, 10, sdf.parse("18/04/2021"), TipoOperacion.CHEQUE_PAGARE));
//            deudas.add(new DeudaDto(5, new EstadosListDto(null), 10, 5, 10, sdf.parse("19/05/2021"), TipoOperacion.CCC_TC));
//            deudas.add(new DeudaDto(6, new EstadosListDto(null), 10, 6, 7, sdf.parse("09/06/2021"), TipoOperacion.PRESTAMOS));
//            deudas.add(new DeudaDto(7, new EstadosListDto(null), 10, 7, 12, sdf.parse("19/07/2021"), TipoOperacion.CHEQUE_PAGARE));
//            deudas.add(new DeudaDto(8, new EstadosListDto(null), 10, 8, 10, sdf.parse("23/08/2021"), TipoOperacion.CCC_TC));
//            deudas.add(new DeudaDto(9, new EstadosListDto(null), 10, 9, 7, sdf.parse("30/09/2021"), TipoOperacion.PRESTAMOS));
//            deudas.add(new DeudaDto(10, new EstadosListDto(null), 10, 1, 10, sdf.parse("31/10/2021"), TipoOperacion.CHEQUE_PAGARE));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return deudas;
//    }
//
//    public static List<AccionDto> getAccionesMock() {
//        List<AccionDto> acciones = new ArrayList<>();
//        acciones.add(new AccionDto(1, TipoAccionista.TIPO_A, 100));
//        acciones.add(new AccionDto(2, TipoAccionista.TIPO_B, 1000));
//        acciones.add(new AccionDto(3, TipoAccionista.TIPO_A, 10000));
//        acciones.add(new AccionDto(4, TipoAccionista.TIPO_B, 1000));
//        acciones.add(new AccionDto(5, TipoAccionista.TIPO_A, 100));
//        acciones.add(new AccionDto(6, TipoAccionista.TIPO_A, 100));
//        acciones.add(new AccionDto(7, TipoAccionista.TIPO_B, 1000));
//        acciones.add(new AccionDto(8, TipoAccionista.TIPO_A, 10000));
//        acciones.add(new AccionDto(9, TipoAccionista.TIPO_B, 1000));
//        acciones.add(new AccionDto(10, TipoAccionista.TIPO_A, 100));
//
//        acciones.add(new AccionDto(11, TipoAccionista.TIPO_A, 10000));
//        acciones.add(new AccionDto(12, TipoAccionista.TIPO_B, 10000));
//        acciones.add(new AccionDto(13, TipoAccionista.TIPO_A, 1000));
//        acciones.add(new AccionDto(14, TipoAccionista.TIPO_B, 10000));
//        acciones.add(new AccionDto(15, TipoAccionista.TIPO_A, 1000));
//        acciones.add(new AccionDto(16, TipoAccionista.TIPO_B, 100));
//        acciones.add(new AccionDto(17, TipoAccionista.TIPO_A, 10000));
//        acciones.add(new AccionDto(18, TipoAccionista.TIPO_B, 1000));
//        acciones.add(new AccionDto(19, TipoAccionista.TIPO_A, 1000));
//        acciones.add(new AccionDto(20, TipoAccionista.TIPO_B, 1000));
//        return acciones;
//    }
//
//    public static List<AccionistaDto> getAccionistasMock() {
//        List<AccionistaDto> accionistas = new ArrayList<>();
//        accionistas.add(new AccionistaDto(1, "11-34613461-2", "SaracatungaSRL1", 10, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(1, "11-34613461-2", "SaracatungaSRL1", 15, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(2, "13-14634659-2", "SaracatungaSRL2", 11, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(3, "11-34515345-2", "SaracatungaSRL3", 13, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(4, "15-65678234-3", "SaracatungaSRL4", 14, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(5, "15-46889568-4", "SaracatungaSRL5", 12, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(6, "14-84876536-5", "SaracatungaSRL6", 11, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(7, "13-54673456-6", "SaracatungaSRL7", 19, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(8, "13-78631757-9", "SaracatungaSRL8", 18, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(9, "13-87375787-9", "SaracatungaSRL9", 16, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(10, "13-31478135-9", "SaracatungaSRL10", 17, TipoAccionista.TIPO_B));
//
//        accionistas.add(new AccionistaDto(11, "11-35683567-1", "SaracatungaSRL11", 13, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(12, "11-35467358-2", "SaracatungaSRL11", 14, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(13, "12-86478458-4", "SaracatungaSRL12", 16, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(14, "13-45845857-3", "SaracatungaSRL13", 23, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(15, "13-37567856-5", "SaracatungaSRL14", 26, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(16, "13-07589578-6", "SaracatungaSRL15", 21, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(17, "17-24562456-7", "SaracatungaSRL16", 17, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(18, "18-25467274-2", "SaracatungaSRL17", 23, TipoAccionista.TIPO_A));
//        accionistas.add(new AccionistaDto(19, "16-24567282-9", "SaracatungaSRL18", 12, TipoAccionista.TIPO_B));
//        accionistas.add(new AccionistaDto(20, "13-56734576-1", "SaracatungaSRL19", 18, TipoAccionista.TIPO_A));
//        return accionistas;
//    }
//
//    public static List<LineaDeCreditoDto> getLineasDeCreditoMock() {
//        List<LineaDeCreditoDto> lineasDeCredito = new ArrayList<>();
//        List<ContraGarantiaDto> contraGarantias = getContragarantiasMock();
//        List<OperacionPrestamoDto> operacionPrestamoList = getOperacionesPrestamoMock();
//        List<OperacionChequePagareDto> operacionChequePagareList = getOperacionesChequePagareMock();
//        List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTCList = getOperacionesCuentaCorrienteTcMock();
//
//        try {
//            EstadosListDto estadoList = new EstadosListDto(new ArrayList<>());
//            estadoList.agregarEstado(new EstadoDto(sdf.parse("24/04/2020"), LineaDeCreditoEstado.EN_REVISION.toString()));
//            estadoList.agregarEstado(new EstadoDto(new Date(), LineaDeCreditoEstado.APROBADA.toString()));
//
//            lineasDeCredito.add(new LineaDeCreditoDto(1, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(0, 1), 2500, estadoList, operacionPrestamoList.subList(0, 1), operacionChequePagareList.subList(0, 1), operacionCuentaCorrienteTCList.subList(0, 1)));
//            lineasDeCredito.add(new LineaDeCreditoDto(2, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(1, 2), 2500, estadoList, operacionPrestamoList.subList(1, 2), operacionChequePagareList.subList(1, 2), operacionCuentaCorrienteTCList.subList(1, 2)));
//            lineasDeCredito.add(new LineaDeCreditoDto(3, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(2, 3), 2500, estadoList, operacionPrestamoList.subList(2, 3), operacionChequePagareList.subList(2, 3), operacionCuentaCorrienteTCList.subList(2, 3)));
//            lineasDeCredito.add(new LineaDeCreditoDto(4, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(3, 4), 2500, estadoList, operacionPrestamoList.subList(3, 4), operacionChequePagareList.subList(3, 4), operacionCuentaCorrienteTCList.subList(3, 4)));
//            lineasDeCredito.add(new LineaDeCreditoDto(5, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(4, 5), 2500, estadoList, operacionPrestamoList.subList(4, 5), operacionChequePagareList.subList(4, 5), operacionCuentaCorrienteTCList.subList(4, 5)));
//            lineasDeCredito.add(new LineaDeCreditoDto(6, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(5, 6), 2500, estadoList, operacionPrestamoList.subList(5, 6), operacionChequePagareList.subList(5, 6), operacionCuentaCorrienteTCList.subList(5, 6)));
//            lineasDeCredito.add(new LineaDeCreditoDto(7, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(6, 7), 2500, estadoList, operacionPrestamoList.subList(6, 7), operacionChequePagareList.subList(6, 7), operacionCuentaCorrienteTCList.subList(6, 7)));
//            lineasDeCredito.add(new LineaDeCreditoDto(8, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(7, 8), 2500, estadoList, operacionPrestamoList.subList(7, 8), operacionChequePagareList.subList(7, 8), operacionCuentaCorrienteTCList.subList(7, 8)));
//            lineasDeCredito.add(new LineaDeCreditoDto(9, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(8, 9), 2500, estadoList, operacionPrestamoList.subList(8, 9), operacionChequePagareList.subList(8, 9), operacionCuentaCorrienteTCList.subList(8, 9)));
//            lineasDeCredito.add(new LineaDeCreditoDto(10, 10000, sdf.parse("31/12/2021"), contraGarantias.subList(9, 10), 2500, estadoList, operacionPrestamoList.subList(9, 10), operacionChequePagareList.subList(9, 10), operacionCuentaCorrienteTCList.subList(9, 10)));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return lineasDeCredito;
//    }
//
//    public static List<ContraGarantiaDto> getContragarantiasMock() {
//        List<ContraGarantiaDto> contraGarantias = new ArrayList<>();
//        try {
//            contraGarantias.add(new ContraGarantiaDto(1, 10000, sdf.parse("12/01/2021")));
//            contraGarantias.add(new ContraGarantiaDto(2, 10000, sdf.parse("21/01/2021")));
//            contraGarantias.add(new ContraGarantiaDto(3, 10000, sdf.parse("31/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(4, 10000, sdf.parse("30/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(5, 10000, sdf.parse("27/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(6, 10000, sdf.parse("24/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(7, 10000, sdf.parse("23/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(8, 10000, sdf.parse("21/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(9, 10000, sdf.parse("12/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(10, 10000, sdf.parse("20/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(11, 10000, sdf.parse("29/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(12, 10000, sdf.parse("30/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(13, 10000, sdf.parse("27/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(14, 10000, sdf.parse("18/04/2021")));
//            contraGarantias.add(new ContraGarantiaDto(15, 10000, sdf.parse("16/04/2021")));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return contraGarantias;
//    }
//
//    public static List<OperacionCuentaCorrienteTcDto> getOperacionesCuentaCorrienteTcMock() {
//        List<OperacionCuentaCorrienteTcDto> operacionCuentaCorrienteTCList = new ArrayList<>();
//        try {
//            EstadosListDto estadoListOperacion1 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("24/06/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("24/06/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("31/08/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion2 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("12/06/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("12/06/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("18/06/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion3 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("06/05/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("06/05/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("13/05/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion4 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("18/02/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("18/02/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("25/02/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion5 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("25/09/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("25/09/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("01/10/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion6 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("03/08/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("03/08/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("10/08/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion7 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("18/12/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("18/12/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("25/09/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion8 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("10/10/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("10/10/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("17/10/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion9 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("21/04/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("21/04/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("28/04/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion10 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("01/12/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("01/12/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("08/12/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListComision1 = new EstadosListDto(new ArrayList<>());
//            estadoListComision1.agregarEstado(new EstadoDto(sdf.parse("31/08/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision1.agregarEstado(new EstadoDto(sdf.parse("07/09/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision2 = new EstadosListDto(new ArrayList<>());
//            estadoListComision2.agregarEstado(new EstadoDto(sdf.parse("18/06/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision2.agregarEstado(new EstadoDto(sdf.parse("25/06/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision3 = new EstadosListDto(new ArrayList<>());
//            estadoListComision3.agregarEstado(new EstadoDto(sdf.parse("13/05/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision3.agregarEstado(new EstadoDto(sdf.parse("20/05/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision4 = new EstadosListDto(new ArrayList<>());
//            estadoListComision4.agregarEstado(new EstadoDto(sdf.parse("25/02/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision4.agregarEstado(new EstadoDto(sdf.parse("01/03/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision5 = new EstadosListDto(new ArrayList<>());
//            estadoListComision5.agregarEstado(new EstadoDto(sdf.parse("01/10/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision5.agregarEstado(new EstadoDto(sdf.parse("08/10/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision6 = new EstadosListDto(new ArrayList<>());
//            estadoListComision6.agregarEstado(new EstadoDto(sdf.parse("10/08/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision6.agregarEstado(new EstadoDto(sdf.parse("17/08/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision7 = new EstadosListDto(new ArrayList<>());
//            estadoListComision7.agregarEstado(new EstadoDto(sdf.parse("25/09/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision7.agregarEstado(new EstadoDto(sdf.parse("01/10/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision8 = new EstadosListDto(new ArrayList<>());
//            estadoListComision8.agregarEstado(new EstadoDto(sdf.parse("17/10/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision8.agregarEstado(new EstadoDto(sdf.parse("24/10/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision9 = new EstadosListDto(new ArrayList<>());
//            estadoListComision9.agregarEstado(new EstadoDto(sdf.parse("28/04/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision9.agregarEstado(new EstadoDto(sdf.parse("05/07/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision10 = new EstadosListDto(new ArrayList<>());
//            estadoListComision10.agregarEstado(new EstadoDto(sdf.parse("08/12/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision10.agregarEstado(new EstadoDto(sdf.parse("15/12/2020"), ComisionEstado.FACTURADO.toString()));
//
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("25/06/2021"), 250, 1, estadoListOperacion1, new ComisionDto(estadoListComision1, 2500, 5), 1, sdf.parse("24/06/2020"), "HSBC"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("13/04/2021"), 250, 2, estadoListOperacion2, new ComisionDto(estadoListComision2, 2500, 5), 1, sdf.parse("12/06/2020"), "PATAGONIA"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("11/01/2021"), 250, 3, estadoListOperacion3, new ComisionDto(estadoListComision3, 2500, 5), 1, sdf.parse("06/05/2020"), "BBVA"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("05/02/2021"), 250, 4, estadoListOperacion4, new ComisionDto(estadoListComision4, 2500, 5), 1, sdf.parse("18/02/2020"), "Galicia"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("07/10/2021"), 250, 5, estadoListOperacion5, new ComisionDto(estadoListComision5, 2500, 5), 1, sdf.parse("25/09/2020"), "SANTANDER"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("16/12/2021"), 250, 6, estadoListOperacion6, new ComisionDto(estadoListComision6, 2500, 5), 1, sdf.parse("03/08/2020"), "HSBC"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("27/11/2021"), 250, 7, estadoListOperacion7, new ComisionDto(estadoListComision7, 2500, 5), 1, sdf.parse("18/12/2020"), "PATAGONIA"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("09/09/2021"), 250, 8, estadoListOperacion8, new ComisionDto(estadoListComision8, 2500, 4), 1, sdf.parse("10/10/2020"), "Galicia"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("02/03/2021"), 250, 9, estadoListOperacion9, new ComisionDto(estadoListComision9, 2500, 3), 1, sdf.parse("21/04/2020"), "BBVA"));
//            operacionCuentaCorrienteTCList.add(new OperacionCuentaCorrienteTcDto(2500, sdf.parse("30/04/2021"), 250, 10, estadoListOperacion10, new ComisionDto(estadoListComision10, 2500, 2), 1, sdf.parse("01/12/2020"), "SANTANDER"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return operacionCuentaCorrienteTCList;
//    }
//
//    public static List<OperacionChequePagareDto> getOperacionesChequePagareMock() {
//        List<OperacionChequePagareDto> operacionChequePagareList = new ArrayList<>();
//        try {
//            EstadosListDto estadoListOperacion1 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("17/04/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("17/04/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("24/04/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion2 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("05/03/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("05/03/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("12/03/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion3 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("16/02/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("16/02/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("23/02/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion4 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("06/01/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("06/01/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("13/01/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion5 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("04/07/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("04/07/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("11/07/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion6 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("20/08/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("20/08/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("27/08/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion7 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("13/09/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("13/09/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("20/09/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion8 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("14/10/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("14/10/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("21/10/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion9 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("21/11/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("21/11/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("28/11/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion10 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("11/12/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("11/12/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("18/12/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListComision1 = new EstadosListDto(new ArrayList<>());
//            estadoListComision1.agregarEstado(new EstadoDto(sdf.parse("24/04/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision1.agregarEstado(new EstadoDto(sdf.parse("01/05/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision2 = new EstadosListDto(new ArrayList<>());
//            estadoListComision2.agregarEstado(new EstadoDto(sdf.parse("12/03/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision2.agregarEstado(new EstadoDto(sdf.parse("19/03/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision3 = new EstadosListDto(new ArrayList<>());
//            estadoListComision3.agregarEstado(new EstadoDto(sdf.parse("23/02/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision3.agregarEstado(new EstadoDto(sdf.parse("30/02/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision4 = new EstadosListDto(new ArrayList<>());
//            estadoListComision4.agregarEstado(new EstadoDto(sdf.parse("13/01/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision4.agregarEstado(new EstadoDto(sdf.parse("20/01/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision5 = new EstadosListDto(new ArrayList<>());
//            estadoListComision5.agregarEstado(new EstadoDto(sdf.parse("11/07/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision5.agregarEstado(new EstadoDto(sdf.parse("18/07/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision6 = new EstadosListDto(new ArrayList<>());
//            estadoListComision6.agregarEstado(new EstadoDto(sdf.parse("27/08/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision6.agregarEstado(new EstadoDto(sdf.parse("03/09/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision7 = new EstadosListDto(new ArrayList<>());
//            estadoListComision7.agregarEstado(new EstadoDto(sdf.parse("20/09/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision7.agregarEstado(new EstadoDto(sdf.parse("27/09/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision8 = new EstadosListDto(new ArrayList<>());
//            estadoListComision8.agregarEstado(new EstadoDto(sdf.parse("21/10/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision8.agregarEstado(new EstadoDto(sdf.parse("28/10/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision9 = new EstadosListDto(new ArrayList<>());
//            estadoListComision9.agregarEstado(new EstadoDto(sdf.parse("28/11/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision9.agregarEstado(new EstadoDto(sdf.parse("05/12/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision10 = new EstadosListDto(new ArrayList<>());
//            estadoListComision10.agregarEstado(new EstadoDto(sdf.parse("18/12/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision10.agregarEstado(new EstadoDto(sdf.parse("25/12/2020"), ComisionEstado.FACTURADO.toString()));
//
//            operacionChequePagareList.add(new OperacionChequePagareDto(11, estadoListOperacion1, new ComisionDto(estadoListComision1, 2500, 5), 1, sdf.parse("17/04/2020"), 2500, "BBVA", 1, sdf.parse("04/06/2021"), "1543281790", 1500));
//            operacionChequePagareList.add(new OperacionChequePagareDto(12, estadoListOperacion2, new ComisionDto(estadoListComision2, 8521, 5), 1, sdf.parse("05/03/2020"), 8521, "SANTANDER", 1, sdf.parse("06/06/2021"), "3643642311", 6521));
//            operacionChequePagareList.add(new OperacionChequePagareDto(13, estadoListOperacion3, new ComisionDto(estadoListComision3, 953, 5), 1, sdf.parse("16/02/2020"), 953, "RIO", 1, sdf.parse("07/06/2021"), "2362543623", 753));
//            operacionChequePagareList.add(new OperacionChequePagareDto(14, estadoListOperacion4, new ComisionDto(estadoListComision4, 8321, 5), 1, sdf.parse("06/01/2020"), 8321, "SANTANDER", 1, sdf.parse("05/06/2021"), "9761234598", 8321));
//            operacionChequePagareList.add(new OperacionChequePagareDto(15, estadoListOperacion5, new ComisionDto(estadoListComision5, 9521, 5), 1, sdf.parse("04/07/2020"), 9521, "HSBC", 1, sdf.parse("09/06/2021"), "5678129312", 6521));
//            operacionChequePagareList.add(new OperacionChequePagareDto(16, estadoListOperacion6, new ComisionDto(estadoListComision6, 3684, 5), 1, sdf.parse("20/08/2020"), 3684, "PATAGONIA", 1, sdf.parse("02/06/2021"), "4567829467", 2684));
//            operacionChequePagareList.add(new OperacionChequePagareDto(17, estadoListOperacion7, new ComisionDto(estadoListComision7, 12487, 5), 1, sdf.parse("13/09/2020"), 21487, "BBVA", 1, sdf.parse("01/06/2021"), "9741289771", 20487));
//            operacionChequePagareList.add(new OperacionChequePagareDto(18, estadoListOperacion8, new ComisionDto(estadoListComision8, 1369, 4), 1, sdf.parse("14/10/2020"), 1369, "HSBC", 1, sdf.parse("15/06/2021"), "9754315764", 1269));
//            operacionChequePagareList.add(new OperacionChequePagareDto(19, estadoListOperacion9, new ComisionDto(estadoListComision9, 523, 3), 1, sdf.parse("28/11/2020"), 523, "Galicia", 1, sdf.parse("22/06/2021"), "3664197586", 323));
//            operacionChequePagareList.add(new OperacionChequePagareDto(20, estadoListOperacion10, new ComisionDto(estadoListComision10, 15522, 2), 1, sdf.parse("18/12/2020"), 155220, "PATAGONIA", 1, sdf.parse("24/06/2021"), "2316457231", 155220));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return operacionChequePagareList;
//    }
//
//    public static List<OperacionPrestamoDto> getOperacionesPrestamoMock() {
//        List<OperacionPrestamoDto> operacionPrestamoList = new ArrayList<>();
//        try {
//            EstadosListDto estadoListOperacion1 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("07/04/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("07/04/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion1.agregarEstado(new EstadoDto(sdf.parse("14/04/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion2 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("05/06/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("05/06/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion2.agregarEstado(new EstadoDto(sdf.parse("12/06/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion3 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("12/02/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("12/02/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion3.agregarEstado(new EstadoDto(sdf.parse("16/02/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion4 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("26/01/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("26/01/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion4.agregarEstado(new EstadoDto(sdf.parse("02/02/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion5 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("07/08/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("07/08/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion5.agregarEstado(new EstadoDto(sdf.parse("14/08/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion6 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("10/05/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("10/05/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion6.agregarEstado(new EstadoDto(sdf.parse("17/05/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion7 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("23/10/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("23/10/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion7.agregarEstado(new EstadoDto(sdf.parse("30/10/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion8 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("30/10/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("30/10/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion8.agregarEstado(new EstadoDto(sdf.parse("06/11/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion9 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("20/11/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("20/11/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion9.agregarEstado(new EstadoDto(sdf.parse("27/11/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListOperacion10 = new EstadosListDto(new ArrayList<>());
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("23/02/2020"), OperacionEstado.INGRESADO.toString()));
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("23/02/2020"), OperacionEstado.CON_CERTIFICADO_EMITIDO.toString()));
//            estadoListOperacion10.agregarEstado(new EstadoDto(sdf.parse("30/02/2020"), OperacionEstado.MONETIZADO_OPERADO.toString()));
//
//            EstadosListDto estadoListComision1 = new EstadosListDto(new ArrayList<>());
//            estadoListComision1.agregarEstado(new EstadoDto(sdf.parse("14/04/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision1.agregarEstado(new EstadoDto(sdf.parse("21/04/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision2 = new EstadosListDto(new ArrayList<>());
//            estadoListComision2.agregarEstado(new EstadoDto(sdf.parse("12/06/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision2.agregarEstado(new EstadoDto(sdf.parse("19/06/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision3 = new EstadosListDto(new ArrayList<>());
//            estadoListComision3.agregarEstado(new EstadoDto(sdf.parse("16/02/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision3.agregarEstado(new EstadoDto(sdf.parse("23/02/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision4 = new EstadosListDto(new ArrayList<>());
//            estadoListComision4.agregarEstado(new EstadoDto(sdf.parse("02/02/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision4.agregarEstado(new EstadoDto(sdf.parse("09/02/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision5 = new EstadosListDto(new ArrayList<>());
//            estadoListComision5.agregarEstado(new EstadoDto(sdf.parse("14/08/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision5.agregarEstado(new EstadoDto(sdf.parse("21/08/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision6 = new EstadosListDto(new ArrayList<>());
//            estadoListComision6.agregarEstado(new EstadoDto(sdf.parse("17/05/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision6.agregarEstado(new EstadoDto(sdf.parse("24/05/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision7 = new EstadosListDto(new ArrayList<>());
//            estadoListComision7.agregarEstado(new EstadoDto(sdf.parse("30/10/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision7.agregarEstado(new EstadoDto(sdf.parse("06/10/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision8 = new EstadosListDto(new ArrayList<>());
//            estadoListComision8.agregarEstado(new EstadoDto(sdf.parse("06/11/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision8.agregarEstado(new EstadoDto(sdf.parse("13/11/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision9 = new EstadosListDto(new ArrayList<>());
//            estadoListComision9.agregarEstado(new EstadoDto(sdf.parse("27/11/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision9.agregarEstado(new EstadoDto(sdf.parse("04/12/2020"), ComisionEstado.FACTURADO.toString()));
//
//            EstadosListDto estadoListComision10 = new EstadosListDto(new ArrayList<>());
//            estadoListComision10.agregarEstado(new EstadoDto(sdf.parse("30/02/2020"), ComisionEstado.CALCULADO.toString()));
//            estadoListComision10.agregarEstado(new EstadoDto(sdf.parse("06/02/2020"), ComisionEstado.FACTURADO.toString()));
//
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("20/06/2021"), 6, SistemaAmortizacion.ALEMAN, 0, 21, estadoListOperacion1, new ComisionDto(estadoListComision1, 2500, 4), 1, sdf.parse("07/04/2020"), "Galicia"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("22/03/2021"), 6, SistemaAmortizacion.FRANCES, 0, 22, estadoListOperacion2, new ComisionDto(estadoListComision2, 2500, 4), 1, sdf.parse("05/06/2020"), "PATAGONIA"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("21/01/2021"), 6, SistemaAmortizacion.AMERICANO, 0, 23, estadoListOperacion3, new ComisionDto(estadoListComision3, 2500, 4), 1, sdf.parse("12/02/2020"), "HSBC"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("12/06/2021"), 6, SistemaAmortizacion.ALEMAN, 0, 24, estadoListOperacion4, new ComisionDto(estadoListComision4, 2500, 4), 1, sdf.parse("26/01/2020"), "BBVA"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("13/04/2021"), 6, SistemaAmortizacion.FRANCES, 0, 25, estadoListOperacion5, new ComisionDto(estadoListComision5, 2500, 4), 1, sdf.parse("07/08/2020"), "SANTANDER"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("14/09/2021"), 6, SistemaAmortizacion.AMERICANO, 0, 26, estadoListOperacion6, new ComisionDto(estadoListComision6, 2500, 4), 1, sdf.parse("10/05/2020"), "Galicia"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("17/10/2021"), 6, SistemaAmortizacion.ALEMAN, 0, 27, estadoListOperacion7, new ComisionDto(estadoListComision7, 2500, 4), 1, sdf.parse("23/10/2020"), "BBVA"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("19/05/2021"), 6, SistemaAmortizacion.FRANCES, 0, 28, estadoListOperacion8, new ComisionDto(estadoListComision8, 2500, 3), 1, sdf.parse("30/10/2020"), "RIO"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("27/07/2021"), 12, SistemaAmortizacion.AMERICANO, 0, 29, estadoListOperacion9, new ComisionDto(estadoListComision9, 2500, 2), 2, sdf.parse("20/11/2020"), "RIO"));
//            operacionPrestamoList.add(new OperacionPrestamoDto(2500, 1, sdf.parse("03/03/2021"), 12, SistemaAmortizacion.ALEMAN, 0, 30, estadoListOperacion10, new ComisionDto(estadoListComision10, 2500, 1), 1, sdf.parse("23/02/2020"), "BBVA"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return operacionPrestamoList;
//    }
//
//    public static List<AporteDto> getAportesMock() {
//        List<AporteDto> aportes = new ArrayList<>();
//        aportes.add(new AporteDto(1, 200000, new Date()));
//        return aportes;
//    }
//
//    public static List<SocioProtectorDto> getSociosProcMock() {
//
//        List<SocioProtectorDto> socioProtecor = new ArrayList<>();
//        List<AccionDto> acciones = getAccionesMock();
//        List<AccionistaDto> accionistas = getAccionistasMock();
//        List<AporteDto> aportes = getAportesMock();
//        EstadosListDto estadoListSocio = new EstadosListDto(new ArrayList<>());
//
//        try {
//            estadoListSocio.agregarEstado(new EstadoDto(sdf.parse("01/01/2020"), SocioEstado.INGRESADO.toString()));
//            estadoListSocio.agregarEstado(new EstadoDto(sdf.parse("01/01/2020"), SocioEstado.CONTROLADO.toString()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        // SOCIO PROTECTOR 1
//        socioProtecor.add(new SocioProtectorDto(11, "35-111111-1", "Amazon", new Date(),
//                TamanioEmpresa.GRANDE, "Software", "Calle Falsa 6347",
//                "46280802", "amazon@amazon.com", TipoPostulante.PLENO.name(),
//                acciones.subList(10, 11), accionistas.subList(10, 11), SegmentoSocio.NORMAL, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 2
//        socioProtecor.add(new SocioProtectorDto(12, "35-222222-2", "Microsoft", new Date(),
//                TamanioEmpresa.PEQUEÑA, "Software", "Calle Falsa 4578",
//                "74272456", "microsoft@microsoft.com", TipoPostulante.PLENO.name(),
//                acciones.subList(11, 12), accionistas.subList(11, 12), SegmentoSocio.BRONCE, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 3
//        socioProtecor.add(new SocioProtectorDto(13, "35-333333-3", "RedHat", new Date(),
//                TamanioEmpresa.GRANDE, "Software", "Calle Falsa 1873",
//                "242452456", "redhat@redhat.com", TipoPostulante.PLENO.name(),
//                acciones.subList(12, 13), accionistas.subList(12, 13), SegmentoSocio.NORMAL, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 4
//        socioProtecor.add(new SocioProtectorDto(14, "35-444444-4", "JetBrains", new Date(),
//                TamanioEmpresa.MEDIANA, "Software", "Calle Falsa 2743",
//                "24562457", "jetbrains@jetbrains.com", TipoPostulante.PLENO.name(),
//                acciones.subList(13, 14), accionistas.subList(13, 14), SegmentoSocio.PLATINO, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 5
//        socioProtecor.add(new SocioProtectorDto(15, "35-555555-5", "Pringles", new Date(),
//                TamanioEmpresa.MEDIANA, "Comestibles", "Calle Falsa 1265",
//                "67357246", "pringles@pringles.com", TipoPostulante.PLENO.name(),
//                acciones.subList(14, 15), accionistas.subList(14, 15), SegmentoSocio.NORMAL, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 6
//        socioProtecor.add(new SocioProtectorDto(16, "35-666666-6", "Lays", new Date(),
//                TamanioEmpresa.GRANDE, "Comestibles", "Calle Falsa 3255",
//                "24577245", "lays@lays.com", TipoPostulante.PLENO.name(),
//                acciones.subList(15, 16), accionistas.subList(15, 16), SegmentoSocio.NORMAL, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 7
//        socioProtecor.add(new SocioProtectorDto(17, "35-777777-7", "Logitech", new Date(),
//                TamanioEmpresa.PEQUEÑA, "Tecnologia", "Calle Falsa 5678",
//                "24574257", "logitech@logitech.com", TipoPostulante.PLENO.name(),
//                acciones.subList(16, 17), accionistas.subList(16, 17), SegmentoSocio.BRONCE, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 8
//        socioProtecor.add(new SocioProtectorDto(18, "35-888888-8", "NVIDIA", new Date(),
//                TamanioEmpresa.GRANDE, "Tecnologia", "Calle Falsa 8958",
//                "23468654", "nvidia@nvidia.com", TipoPostulante.PLENO.name(),
//                acciones.subList(17, 18), accionistas.subList(17, 18), SegmentoSocio.ORO, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 9
//        socioProtecor.add(new SocioProtectorDto(19, "35-999999-9", "System76", new Date(),
//                TamanioEmpresa.GRANDE, "Software", "Calle Falsa 3456",
//                "47476588", "system76@system76.com", TipoPostulante.PLENO.name(),
//                acciones.subList(18, 19), accionistas.subList(18, 19), SegmentoSocio.NORMAL, estadoListSocio, aportes.subList(0, 1)));
//
//        // SOCIO PROTECTOR 10
//        socioProtecor.add(new SocioProtectorDto(20, "11-34613461-3", "ASUS", new Date(),
//                TamanioEmpresa.PEQUEÑA, "Tecnologia", "Calle Falsa 7536",
//                "42754262", "asus@asus.com", TipoPostulante.PLENO.name(),
//                acciones.subList(19, 20), accionistas.subList(19, 20), SegmentoSocio.PLATINO, estadoListSocio, aportes.subList(0, 1)));
//        return socioProtecor;
//    }
//}