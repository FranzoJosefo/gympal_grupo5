package edu.uade.forms;

import javax.swing.*;
import java.awt.event.*;

public class DialogError extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JLabel lblMensaje;

    public DialogError(String mensaje) {
        this.lblMensaje.setText(mensaje);
        setContentPane(contentPane);
        this.setTitle(mensaje);
        getRootPane().setDefaultButton(buttonCancel);
        this.setSize(400, 300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

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

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
