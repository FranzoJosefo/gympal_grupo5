package edu.uade.forms;

import edu.uade.enums.DataFilesNames;
import edu.uade.forms.socio.FormSociosBulk;
import edu.uade.mock.EntitiesMocks;
import edu.uade.service.ApiService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeForm extends JFrame {

    private JPanel rootPanel;
    private JPanel btnsPanel;
    private JPanel titlePanel;
    private JButton btnSocios;
    private JButton btnDeudas;
    private JButton btnOperaciones;
    private JButton btnTBD2;

    private HomeForm self;

    public HomeForm() {
        super();

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
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();
        seed();

        this.self = this;

    }

    private void seed() {
        ApiService.grabar(EntitiesMocks.getOperacionesCuentaCorrienteTcMock(), DataFilesNames.FILE_OPS_TARJETAS_CUENTAS_CORRIENTES.getName());
        ApiService.grabar(EntitiesMocks.getOperacionesChequePagareMock(), DataFilesNames.FILE_OPS_CHEQUES_PAGARES.getName());
        ApiService.grabar(EntitiesMocks.getOperacionesPrestamoMock(), DataFilesNames.FILE_OPS_PRESTAMOS.getName());
        ApiService.grabar(EntitiesMocks.getLineasDeCreditoMock(), DataFilesNames.FILE_LINEAS_DE_CREDITO.getName());
        ApiService.grabar(EntitiesMocks.getDeudasMock(), DataFilesNames.FILE_DEUDAS.getName());
        ApiService.grabar(EntitiesMocks.getSociosMock(), DataFilesNames.FILE_SOCIOS_PARTICIPES.getName());
        ApiService.grabar(EntitiesMocks.getSociosProcMock(), DataFilesNames.FILE_SOCIOS_PROTECTOR.getName());
        ApiService.grabar(EntitiesMocks.getTablasComisionMock(), DataFilesNames.FILE_TABLAS_COMISION.getName());
    }

    private void asociarEventos() {
        btnDeudas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                FrmListaDemo frame = new FrmListaDemo(self);
//                frame.setVisible(true);
            }
        });

        btnSocios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormSociosBulk formSociosBulk = new FormSociosBulk(self);
                formSociosBulk.setVisible(true);
            }
        });

        btnOperaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormOperacionesBulk frame = new FormOperacionesBulk(self);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeForm frame = new HomeForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
