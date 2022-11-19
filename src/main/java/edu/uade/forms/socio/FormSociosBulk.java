package edu.uade.forms.socio;

import edu.uade.DTO.SocioParticipeDto;
import edu.uade.DTO.SocioProtectorDto;
import edu.uade.controllers.SocioController;
import edu.uade.forms.*;
import edu.uade.models.SocioEmpresa;
import edu.uade.models.SocioParticipe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class FormSociosBulk extends JDialog {
    private SocioParticipeDto socioParticipeDto;
    private JPanel contentPane;

    private JButton buttonDetalle;
    private JButton buttonCancel;
    private JPanel botonera;
    private JTabbedPane jTabbedPane;
    private JScrollPane scrollPaneTableParticipes;
    private JScrollPane scrollPaneTableProtectores;
    private JPanel botoneraParticipes;
    private JButton buttonConsolidada;
    private JPanel botoneraProtectores;
    private JButton buttonAddProtector;
    private JButton buttonAddParticipe;
    private JButton buttonComision;
    private JScrollPane scrollPaneTable;
    private JTable sociosParticipeTable;
    private JTable sociosProtectoresTable;
    private String selectedSocioId;
    private String selectedSocioType;
    private final FormSociosBulk self;
    private static final String SOCIO_TYPE_PROTECTOR = "PROTECTOR";
    private static final String SOCIO_TYPE_PARTICIPE = "PARTICIPE";

    public FormSociosBulk(Window owner) {
        super(owner);
        this.setContentPane(contentPane);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonDetalle);
        self = this;

        buttonDetalle.setEnabled(false);
        buttonConsolidada.setEnabled(false);
        buttonComision.setEnabled(false);

        initDefaultListeners();
        initTableSociosParticipes();
        initTableSociosProtectores();
    }


    private void initDefaultListeners() {
        buttonDetalle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToDetalle();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        buttonConsolidada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToConsultaConsolidada();
            }
        });

        buttonAddParticipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormSocio dialog = new FormSocio(getOwner(), null, new OnFormCloseCallback() {
                    @Override
                    public void onModelUpdated() {
                        initTableSociosParticipes();
                        sociosParticipeTable.clearSelection();
                        selectedSocioId = null;
                    }
                });
                dialog.setVisible(true);
            }
        });

        buttonAddProtector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormSocioProtector dialog = new FormSocioProtector(self, null, new OnFormCloseCallback() {
                    @Override
                    public void onModelUpdated() {
                        initTableSociosProtectores();
                        sociosProtectoresTable.clearSelection();
                        selectedSocioId = null;
                    }
                });
                dialog.setVisible(true);
            }
        });

        buttonComision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCalcularComision formCalcularComision = new FormCalcularComision(selectedSocioId);
                formCalcularComision.setVisible(true);
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

    private void initTableSociosParticipes() {
        List<SocioParticipeDto> socioParticipeDtos = SocioController.INSTANCE.getSociosParticipesDto();

        String[] columns = new String[]{
                "SocioID", "Razon Social", "Cuit"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class, String.class
        };

        DefaultTableModel participeModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };

        for (SocioParticipeDto dto : socioParticipeDtos) {
            Object[] o = new Object[3];
            o[0] = dto.getSocioId();
            o[1] = dto.getRazonSocial();
            o[2] = dto.getCuit();
            participeModel.addRow(o);
        }

        //Creo la tabla con el modelo definido
        sociosParticipeTable = new JTable(participeModel);

        //Agrego "Listener" para saber cuando alguien hace click en una fila de la tabla
        sociosParticipeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Guardo el socio seleccionado
                selectedSocioId = (sociosParticipeTable.getValueAt(sociosParticipeTable.getSelectedRow(), 0).toString());
                selectedSocioType = SOCIO_TYPE_PARTICIPE;

                buttonDetalle.setEnabled(true);
                SocioEmpresa socioEmpresa = SocioController.INSTANCE.getSocio(Integer.parseInt(selectedSocioId));
                if (socioEmpresa instanceof SocioParticipe) {
                    if (((SocioParticipe) socioEmpresa).getLineaCredito() != null) {
                        buttonConsolidada.setEnabled(true);
                    } else {
                        buttonConsolidada.setEnabled(false);
                    }
                }
                buttonComision.setEnabled(true);
            }
        });
        scrollPaneTableParticipes.setViewportView(sociosParticipeTable);
    }

    private void initTableSociosProtectores() {
        List<SocioProtectorDto> socioProtectorDtos = SocioController.INSTANCE.getSociosProtectoresDto();

        String[] columns = new String[]{
                "SocioID", "Razon Social", "Cuit"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class, String.class
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };

        for (SocioProtectorDto dto : socioProtectorDtos) {
            Object[] o = new Object[3];
            o[0] = dto.getSocioId();
            o[1] = dto.getRazonSocial();
            o[2] = dto.getCuit();
            model.addRow(o);
        }

        //Creo la tabla con el modelo definido
        sociosProtectoresTable = new JTable(model);

        //Agrego "Listener" para saber cuando alguien hace click en una fila de la tabla
        sociosProtectoresTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Guardo el socio seleccionado
                selectedSocioId = (sociosProtectoresTable.getValueAt(sociosProtectoresTable.getSelectedRow(), 0).toString());
                selectedSocioType = SOCIO_TYPE_PROTECTOR;
                buttonDetalle.setEnabled(true);
            }
        });
        scrollPaneTableProtectores.setViewportView(sociosProtectoresTable);
    }

    private void goToConsultaConsolidada() {
        SocioEmpresa socioEmpresa = SocioController.INSTANCE.getSocio(Integer.parseInt(selectedSocioId));
        if (socioEmpresa instanceof SocioParticipe) {
            if (((SocioParticipe) socioEmpresa).getLineaCredito() != null) {
                FormConsultaConsolidadaSocio dialog = new FormConsultaConsolidadaSocio(getOwner(), selectedSocioId, new OnFormCloseCallback() {
                    public void onModelUpdated() {
                        selectedSocioId = null;
                    }
                });
                dialog.setVisible(true);
                buttonDetalle.setEnabled(false);
            } else {
                DialogError error = new DialogError("El socio no posee una línea de crédito.");
                error.setVisible(true);
            }
        }
    }

    private void goToDetalle() {
        //(getOwner() para que se cierre esta pantalla pero mantenga siempre la Home como WindowsOwner.
        if (selectedSocioId != null || selectedSocioType != null) {
//            self.setVisible(false);

            switch (selectedSocioType) {
                case SOCIO_TYPE_PARTICIPE: {
                    FormSocio dialog = new FormSocio(getOwner(), selectedSocioId, new OnFormCloseCallback() {
                        @Override
                        public void onModelUpdated() {
                            initTableSociosParticipes();
                            sociosParticipeTable.clearSelection();
                            selectedSocioId = null;
                        }
                    });
                    dialog.setVisible(true);
                    buttonDetalle.setEnabled(false);
                    break;
                }
                case SOCIO_TYPE_PROTECTOR: {
                    FormSocioProtector dialog = new FormSocioProtector(getOwner(), selectedSocioId, new OnFormCloseCallback() {
                        @Override
                        public void onModelUpdated() {
                            initTableSociosProtectores();
                            sociosProtectoresTable.clearSelection();
                            selectedSocioType = null;
                        }
                    });
                    dialog.setVisible(true);
                    buttonDetalle.setEnabled(false);
                    buttonConsolidada.setEnabled(false);
                    buttonComision.setEnabled(false);
                    break;
                }
            }
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
