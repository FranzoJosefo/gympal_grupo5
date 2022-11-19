package edu.uade.forms.socio;

import edu.uade.DTO.*;
import edu.uade.controllers.SocioController;
import edu.uade.forms.OnFormCloseCallback;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormConsultaConsolidadaSocio extends JDialog {
    private ConsultaConsolidadaDto consultaConsolidadaDto;
    private JPanel contentPane;
    private JButton buttonCancel;
    private JPanel botonera;
    private JTabbedPane jTabbedPane;
    private JScrollPane scrollPaneTableContragarantias;
    private JTable consultaContragarantiasTable;
    private JScrollPane scrollPaneTableOperaciones;
    private JLabel riesgoVivoLabel;
    private JLabel riesgoVivoField;
    private JLabel utilizadoDeLineaField;
    private JLabel UtilizadoDeLineaLabel;
    private JLabel totalOperadoField;
    private JLabel totalOperadoMonetizadoField;
    private JTable consultaOperacionesTable;
    private int selectedSocioId;
    private final FormConsultaConsolidadaSocio self;

    public FormConsultaConsolidadaSocio(Window owner, String selectedSocioId, OnFormCloseCallback onFormCloseCallback) {
        super(owner);
        this.setContentPane(contentPane);
        this.setSize(600, 600);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.selectedSocioId = Integer.parseInt(selectedSocioId);
        self = this;

        initDefaultListeners();
        initConsultas();


    }


    private void initDefaultListeners() {

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
    private void initConsultas (){
        this.consultaConsolidadaDto = SocioController.INSTANCE.getConsultaConsolidadaSocioDto(selectedSocioId);
        initConsultaContragarantias();
        initConsultaOperaciones();
        initConsultaRiesgoVivo();
    }
    private void initConsultaRiesgoVivo(){
        riesgoVivoField.setText(String.valueOf(consultaConsolidadaDto.getRiesgoVivo()));
        utilizadoDeLineaField.setText(String.valueOf(consultaConsolidadaDto.getUtilizadoDeLinea()));
        totalOperadoMonetizadoField.setText(String.valueOf(consultaConsolidadaDto.getTotalDeOperacionesMonetizadas()));
        totalOperadoField.setText(String.valueOf(consultaConsolidadaDto.getTotalDeOperaciones()));

    }
    private void initConsultaOperaciones() {
        String[] columns = new String[]{
                "Fecha", "Estado", "Entidad", "Tipo", "Monto"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class, String.class, String.class, String.class
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (OperacionChequePagareDto dto : consultaConsolidadaDto.getOperacionChequePagareDto()) {
            List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[5];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = "Cheque / Pagare";
            o[4] = dto.getImporteBruto();
            model.addRow(o);
        }
        for (OperacionCuentaCorrienteTcDto dto : consultaConsolidadaDto.getOperacionCuentaCorrienteTcDtos()) {
            java.util.List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[5];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = "Cuenta Corriente / Tarjeta de crédito";
            o[4] = dto.getImporteTotal();
            model.addRow(o);
        }

        java.util.List<OperacionPrestamoDto> prestamos = consultaConsolidadaDto.getOperacionPrestamoDtos();
        for (OperacionPrestamoDto dto : prestamos) {
            List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[5];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = "Prestamo";
            o[4] = dto.getImporteBruto();
            model.addRow(o);
        }

        //Creo la tabla con el modelo definido
        consultaOperacionesTable = new JTable(model);

        scrollPaneTableOperaciones.setViewportView(consultaOperacionesTable);
    }
    private void initConsultaContragarantias() {

        String[] columns = new String[]{
                "Id Contragarantia", "Monto", "Vigencia"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class, String.class
        };

        DefaultTableModel contraGarantiasModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnClass[columnIndex];
            }
        };

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (ContraGarantiaDto dto : consultaConsolidadaDto.getContraGarantiasDtoList()) {
            Object[] o = new Object[3];
            o[0] = dto.getContraGarantiaId();
            o[1] = dto.getMonto();
            o[2] = sdf.format(dto.getVigencia());
            contraGarantiasModel.addRow(o);
        }

        //Creo la tabla con el modelo definido
        consultaContragarantiasTable = new JTable(contraGarantiasModel);

        scrollPaneTableContragarantias.setViewportView(consultaContragarantiasTable);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
