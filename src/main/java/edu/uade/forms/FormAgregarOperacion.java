package edu.uade.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormAgregarOperacion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private OnFormCloseCallback onFormCloseCallback;
    private String operacionId;

    public FormAgregarOperacion(Window owner, String operacionId, OnFormCloseCallback onFormCloseCallback) {
        super(owner);
        this.operacionId = operacionId;
        setContentPane(contentPane);
        this.setSize(400, 300);
        this.setModal(true);
        this.setTitle("Agregar Operación");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonCancel);
        this.onFormCloseCallback = onFormCloseCallback;

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        onFormCloseCallback.onModelUpdated();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
