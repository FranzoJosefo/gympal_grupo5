package edu.uade.forms;

import edu.uade.controllers.OperacionController;
import edu.uade.enums.DataFilesNames;
import edu.uade.mock.EntitiesMocks;
import edu.uade.service.ApiService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormPrincipal extends JFrame {
    private JPanel rootPanel;
    private JButton btnSocioParticipe;
    private JTextField fieldSocioParticipeId;
    private JTextField fieldSocioProtectorId;
    private JButton btnSocioProtector;
    private FormPrincipal self;

    public FormPrincipal(){
        this.self = self;

        // Set OS Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setContentPane(rootPanel);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //EXIT_ON_CLOSE
        this.setLocationRelativeTo(null);
        //this.pack();
        this.setVisible(true);

        seed();

        asociarEventos();

        runTest();
    }

    private void runTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaOperacion = new Date();
        Date fechaVencimiento = new Date();
        try { fechaOperacion = sdf.parse("8/11/2020");
            fechaVencimiento = sdf.parse("8/04/2021");
        }
        catch (Exception e) { System.out.println("!ERROR: "+e.getMessage()); }
        // SERGIO
        // REGLA #5
        //SocioController.INSTANCE.esSocioAccionista("309090909");
        //SocioController.INSTANCE.esSocioAccionista("303030303");
        // CONSULTA #5
        //SocioController.INSTANCE.getMoraTotalPorFecha(1,fechaOperacion);

        // RAMIRO
        // CONSULTA #4
        //SocioController.INSTANCE.getComisionSocioByTipoOperacion(1, TipoOperacion.CHEQUE_PAGARE);

        OperacionController.INSTANCE.getChequesByBanco("HSBC");

        // MARTIN
        // REGLA #1


        OperacionController.INSTANCE.generarOperacionChequePagare(1,
                100 ,123, fechaOperacion ,
                1000d, "BBVA", 100, fechaVencimiento,
                "303030303");
        OperacionController.INSTANCE.getChequesByBanco("BBVA");
        // CONSULTA #1

        OperacionController.INSTANCE.comisionesDiariasChequesPresentados(fechaOperacion);


    }

    private void seed() {
//      ApiService.grabar(EntitiesMocks.getChequesPagareMock(1,1,"asd"), DataFilesNames.FILE_CHEQUES_PAGARES.getName());
        ApiService.grabar(EntitiesMocks.getSociosMock(), DataFilesNames.FILE_SOCIOS_PARTICIPES.getName());
        ApiService.grabar(EntitiesMocks.getSociosProcMock(),DataFilesNames.FILE_SOCIOS_PROTECTOR.getName());
        ApiService.grabar(EntitiesMocks.getTablasComisionMock(), DataFilesNames.FILE_TABLAS_COMISION.getName());
    }

    private void asociarEventos() {
        btnSocioParticipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormSocio dialog = new FormSocio(self, fieldSocioParticipeId.getText(), new OnFormCloseCallback() {
                    @Override
                    public void onModelUpdated() {

                    }
                });
                dialog.setVisible(true);
            }
        });

        btnSocioProtector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormSocioProtector dialog = new FormSocioProtector(self, fieldSocioProtectorId.getText(), null);
                dialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        FormPrincipal frame = new FormPrincipal();

    }
}
