package edu.uade.forms;

import edu.uade.controllers.SocioController;
import edu.uade.enums.TipoOperacion;

import javax.swing.*;
import java.awt.event.*;

public class FormCalcularComision extends JDialog {

    private JPanel panel;
    private JLabel porcentajeComision;
    private JComboBox<TipoOperacion> comboBox;
    private JButton calcularComisionButton;
    private int socioId;
    private TipoOperacion tipoOperacion;

    public FormCalcularComision(String socioId) {

        this.socioId = Integer.parseInt(socioId);
        this.tipoOperacion = TipoOperacion.valueOf(String.valueOf(TipoOperacion.CHEQUE_PAGARE));
        this.setContentPane(panel);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500, 250);
        getRootPane().setDefaultButton(calcularComisionButton);
        initDefaultListeners();
        initTipoOperacion();
    }

    private void initDefaultListeners() {
        calcularComisionButton.addActionListener(actionEvent -> calcularComision());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        panel.registerKeyboardAction(event -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initTipoOperacion() {

        comboBox.setModel(new DefaultComboBoxModel<>(TipoOperacion.values()));

        comboBox.setSelectedItem(TipoOperacion.values());

        comboBox.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                tipoOperacion = TipoOperacion.valueOf(String.valueOf(comboBox.getSelectedItem()));
                System.out.println("Selección de tipo de operacion: " + tipoOperacion);
            }
        });
    }

    private void calcularComision() {
        porcentajeComision.setText(String.valueOf(SocioController.INSTANCE.getComisionSocioByTipoOperacion(socioId, tipoOperacion)));
    }

    private void onCancel() {
        dispose();
    }
}