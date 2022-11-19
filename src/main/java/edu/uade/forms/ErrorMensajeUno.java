package edu.uade.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorMensajeUno extends JDialog  {
    private JPanel panel1;
    private JButton cerrarButton;
    public ErrorMensajeUno(Window owner)  {
        super(owner);
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        this.setContentPane(panel1);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(cerrarButton);




    }
}
