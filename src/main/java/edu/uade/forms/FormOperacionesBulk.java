package edu.uade.forms;

import edu.uade.DTO.*;
import edu.uade.controllers.OperacionController;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.utils.DateUtil;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormOperacionesBulk extends JDialog {
    private JPanel contentPane;
    private JTabbedPane jTabbedPane;
    private JPanel botonera;
    private JButton buttonBack;
    private JScrollPane scrollPaneCheques;
    private JScrollPane scrollPanePrestamos;
    private JScrollPane scrollPaneCredito;
    private JButton promedioTotalOperadoButton;
    private JLabel tamañoEmpresaLabel;
    private JPanel promedioPanel;
    private JTextField hastaFechaTextField;
    private JPanel desdeFechaPanel;
    private JPanel hastaFechaPanel;
    private JPanel fechaPanel;
    private JPanel promedioResultPanel;
    private JComboBox<String> tamanioEmpresaComboBox;
    private JPanel fechaDesdeDatePickerPanel;
    private JTextField desdeFechaTextField;
    private FormOperacionesBulk self;
    private JDatePickerImpl fechaDesde;
    private JDatePickerImpl fechaHasta;

    public FormOperacionesBulk(Window owner) {
        super(owner);
        this.setContentPane(contentPane);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        self = this;

        initDefaultListeners();
        initTableChequesPagares();
        initTableCuentaCorrienteTC();
        initTablePrestamos();
        initComboBoxTamanioEmpresas();

    }

    private void initComboBoxTamanioEmpresas() {
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        model.addElement(TamanioEmpresa.GRANDE);
        model.addElement(TamanioEmpresa.MEDIANA);
        model.addElement(TamanioEmpresa.PEQUEÑA);
        tamanioEmpresaComboBox.setModel(model);
    }

    private void initDefaultListeners() {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        promedioTotalOperadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desdeFechaDate = desdeFechaTextField.getText();
                String hastaFechaDate = hastaFechaTextField.getText();
                if (DateUtil.isValidDate(desdeFechaDate) && DateUtil.isValidDate(hastaFechaDate)) {
                    FormPromedioOperadoCheques frame = new FormPromedioOperadoCheques(self, TamanioEmpresa.valueOf(tamanioEmpresaComboBox.getSelectedItem().toString()) , desdeFechaDate, hastaFechaDate);
                    frame.setVisible(true);
                    System.out.println("I am a valid Date! :D");
                } else {
                    DialogError errorDialog = new DialogError("Ingrese una fecha valida");
                    errorDialog.setVisible(true);
                }
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

    private void initTablePrestamos() {

        List<OperacionPrestamoDto> prestamosDtos = OperacionController.INSTANCE.getOperacionesPrestamoDtos();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel model = getOperacionTableModel();
        for (OperacionPrestamoDto dto : prestamosDtos) {
            List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[5];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = dto.getImporteBruto();
            o[4] = "Prestamo";
            model.addRow(o);
        }

        scrollPanePrestamos.setViewportView(new JTable(model));
    }

    private void initTableCuentaCorrienteTC() {
        List<OperacionCuentaCorrienteTcDto> operacionesCuentaCorrienteTcDtos = OperacionController.INSTANCE.getOperacionesCuentaCorrienteTcDtos();

        DefaultTableModel model = getOperacionTableModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (OperacionCuentaCorrienteTcDto dto : operacionesCuentaCorrienteTcDtos) {
            java.util.List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[5];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = dto.getImporteTotal();
            o[4] = "Cuenta Corriente / Tarjeta de crédito";
            model.addRow(o);
        }
        scrollPaneCredito.setViewportView(new JTable(model));
    }

    private void initTableChequesPagares() {

        List<OperacionChequePagareDto> chequesPagares = OperacionController.INSTANCE.getOperacionesChequePagaresDtos();

        DefaultTableModel model = getOperacionTableModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (OperacionChequePagareDto dto : chequesPagares) {
            java.util.List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[5];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = dto.getImporteBruto();
            o[4] = "Cheque / Pagare";
            model.addRow(o);
        }

        scrollPaneCheques.setViewportView(new JTable(model));
    }

    private DefaultTableModel getOperacionTableModel() {
        String[] columns = new String[]{
                "Fecha", "Estado", "Entidad", "Importe", "Tipo"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class, String.class, String.class, String.class
        };

        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
