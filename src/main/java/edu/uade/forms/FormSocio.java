package edu.uade.forms;

import edu.uade.DTO.*;
import edu.uade.DTO.EstadoDto;
import edu.uade.DTO.SocioParticipeDto;
import edu.uade.controllers.SocioController;
import edu.uade.enums.*;
import edu.uade.models.SocioEmpresa;
import edu.uade.models.SocioParticipe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormSocio extends JDialog {
    private SocioParticipeDto socioParticipeDto;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField fieldCUIT;
    private JTextField fieldRazonSocial;
    private JComboBox fieldTamanioEmpresa;
    private JTextField fieldActividadPrincipal;
    private JTextField fieldDomicilio;
    private JTextField fieldTelefono;
    private JTextField fieldMail;
    private JComboBox fieldSegmentoSocio;
    private JPanel botonera;
    private JTabbedPane panel;
    private JComboBox fieldPostulante;
    private JScrollPane scrollPaneTableEstados;
    private JLabel lblSocioId;
    private JScrollPane scrollPaneTableOperaciones;
    private JTextField fieldLineaFecha;
    private JTextField fieldLineaEstado;
    private JTextField fieldLineaMontoMaximo;
    private JTextField fieldLineaMontoDisponible;
    private JScrollPane scrollPaneTableGarantias;
    private JPanel panelDetalleLinea;
    private JPanel panelOperaciones;
    private JPanel panelGarantias;
    private JButton buttonAgregarOperacion;
    private JScrollPane scrollPaneTableAcciones;
    private JTextField fieldFecha;
    private JLabel DeudaTotals;
    private JScrollPane listaDeudas;
    private JTable Deudastable;
    private JTable tableEstados;
    private String socioId;
    private OnFormCloseCallback onFormCloseCallback;
    private String selectedOperacionId;
    private JTable operacionesTable;

    public FormSocio(Window owner, String socioId, OnFormCloseCallback onFormCloseCallback) {
        super(owner);
        this.socioId = socioId;
        this.setContentPane(contentPane);
        this.setSize(600, 600);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.onFormCloseCallback = onFormCloseCallback;
        getRootPane().setDefaultButton(buttonCancel);
        buttonAgregarOperacion.setEnabled(false);

        loadDto();

        initDefaultListeners();
        initFieldTamanioEmpresa();
        initFieldSegmentoSocio();
        initFieldPostulante();
        initTableGarantias();
        initTableOperaciones();
        initTableEstados();
        initTableAcciones();
        initTableDeuda();
    }

    private void loadDto() {

        socioParticipeDto = new SocioParticipeDto();
        List<SocioEmpresa> socios = SocioController.INSTANCE.getSocios();
        int newSocioId = socios.get(socios.size() - 1).getSocioId() + 1;
        socioParticipeDto.setSocioId(newSocioId);
        socioParticipeDto.setFecha(new Date());
        socioParticipeDto.setPostulante(TipoPostulante.POSTULANTE_PARTICIPE.name());
        socioParticipeDto.getEstados().getEstados().add(new EstadoDto(new Date(), SocioEstado.INGRESADO.name()));

        if (this.socioId != null && !this.socioId.isEmpty()) {
            SocioEmpresa model = SocioController.INSTANCE.getSocio(Integer.parseInt(this.socioId));
            if (model != null && model instanceof SocioParticipe) {
                socioParticipeDto = ((SocioParticipe) model).toDto();
                if (socioParticipeDto.getLineaCredito() != null) {
                    buttonAgregarOperacion.setEnabled(true);
                }
            }
        }

        this.setData(socioParticipeDto);
    }

    private void initDefaultListeners() {
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

        buttonAgregarOperacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAgregarOperacion();
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

    private void initFieldTamanioEmpresa() {

        fieldTamanioEmpresa.setModel(new DefaultComboBoxModel<>(TamanioEmpresa.values()));

        fieldTamanioEmpresa.setSelectedItem(socioParticipeDto.getTamanioEmpresa());

        fieldTamanioEmpresa.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    TamanioEmpresa seleccion = TamanioEmpresa.valueOf(String.valueOf(fieldTamanioEmpresa.getSelectedItem()));
                    socioParticipeDto.setTamañoEmpresa(seleccion);
                    System.out.println("Selección de tamaño empresa: " + socioParticipeDto.getTamanioEmpresa());
                }
            }
        });
    }

    private void initFieldSegmentoSocio() {

        fieldSegmentoSocio.setModel(new DefaultComboBoxModel<>(SegmentoSocio.values()));

        fieldSegmentoSocio.setSelectedItem(socioParticipeDto.getSegmentoSocio());

        fieldSegmentoSocio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    SegmentoSocio seleccion = SegmentoSocio.valueOf(String.valueOf(fieldSegmentoSocio.getSelectedItem()));
                    socioParticipeDto.setSegmentoSocio(seleccion);
                    System.out.println("Selección de segmento socio: " + socioParticipeDto.getSegmentoSocio());
                }
            }
        });
    }

    private void initFieldPostulante() {

        fieldPostulante.setModel(new DefaultComboBoxModel<>(TipoPostulante.values()));

        fieldPostulante.setSelectedItem(TipoPostulante.valueOf(socioParticipeDto.getPostulante().toUpperCase()));

        fieldPostulante.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    TipoPostulante seleccion = TipoPostulante.valueOf(String.valueOf(fieldPostulante.getSelectedItem()));
                    socioParticipeDto.setPostulante(seleccion.toString()); // TODO Cambiar model para que use el enum de postulante
                    System.out.println("Selección de segmento socio: " + socioParticipeDto.getPostulante());
                }
            }
        });
    }

    private void initTableGarantias() {

        String[] columns = new String[]{
                "Vigencia", "Monto"
        };

        final Class[] columnClass = new Class[]{
                String.class, Float.class
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

        LineaDeCreditoDto lineaDeCreditoDto = socioParticipeDto.getLineaCredito();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (lineaDeCreditoDto != null) {
            List<ContraGarantiaDto> estados = lineaDeCreditoDto.getListadoContragarantiasDto();
            for (ContraGarantiaDto dto : estados) {
                Object[] o = new Object[2];
                o[0] = sdf.format(dto.getVigencia());
                o[1] = dto.getMonto();
                model.addRow(o);
            }
        }

        scrollPaneTableGarantias.setViewportView(new JTable(model));
    }

    private void initTableOperaciones() {

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

        LineaDeCreditoDto lineaDeCreditoDto = socioParticipeDto.getLineaCredito();

        if (lineaDeCreditoDto != null) {
            List<OperacionChequePagareDto> cheques = lineaDeCreditoDto.getOperacionChequePagareDtoList();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (OperacionChequePagareDto dto : cheques) {
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

            List<OperacionCuentaCorrienteTcDto> tarjetas = lineaDeCreditoDto.getOperacionCuentaCorrienteTcDtoList();

            for (OperacionCuentaCorrienteTcDto dto : tarjetas) {
                List<EstadoDto> estadosDto = dto.getEstados().getEstados();
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

            List<OperacionPrestamoDto> prestamos = lineaDeCreditoDto.getOperacionPrestamoDtoList();
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
        }
        operacionesTable = new JTable(model);
        operacionesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                selectedOperacionId = (operacionesTable.getValueAt(operacionesTable.getSelectedRow(), 0).toString());
            }
        });
        scrollPaneTableOperaciones.setViewportView(operacionesTable);
    }

    private void initTableEstados() {

        String[] columns = new String[]{
                "Fecha", "Estado"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class
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

        List<EstadoDto> estados = socioParticipeDto.getEstados().getEstados();
        for (EstadoDto dto : estados) {
            Object[] o = new Object[2];
            o[0] = sdf.format(dto.getFecha());
            o[1] = dto.getNombre();
            model.addRow(o);
        }

        scrollPaneTableEstados.setViewportView(new JTable(model));
    }

    private void initTableAcciones() {

        String[] columns = new String[]{
                "AccionId", "Tipo Accionista", "Precio"
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

        List<AccionDto> accionDtoList = socioParticipeDto.getAcciones();
        for (AccionDto dto : accionDtoList) {
            Object[] o = new Object[3];
            o[0] = String.valueOf(dto.getAccionId());
            o[1] = dto.getTipoAccionista();
            o[2] = String.valueOf(dto.getPrecio());
            model.addRow(o);
        }

        scrollPaneTableAcciones.setViewportView(new JTable(model));
    }

    private void onOK() {
        //TODO isModified for socioProtector???
        if (isModified(socioParticipeDto)) {

            if (socioId != null && !socioId.isEmpty()) {
                SocioEmpresa socio = SocioController.INSTANCE.getSocio(Integer.parseInt(socioId));
                SocioController.INSTANCE.getSocios().remove(socio);
            }
            this.getData(socioParticipeDto);
            if (!socioParticipeDto.getCuit().isEmpty() && !socioParticipeDto.getRazonSocial().isEmpty()) {
                SocioController.INSTANCE.getSocios().add(new SocioParticipe(socioParticipeDto));
                onFormCloseCallback.onModelUpdated();
                dispose();
            }
        }

    }

    private void onCancel() {
        onFormCloseCallback.onModelUpdated();
        dispose();
    }

    private void onAgregarOperacion() {
        FormAgregarOperacion dialog = new FormAgregarOperacion(getOwner(), selectedOperacionId, new OnFormCloseCallback() {
            @Override
            public void onModelUpdated() {
                initTableOperaciones();
                operacionesTable.clearSelection();
                selectedOperacionId = null;
            }
        });
        dialog.setVisible(true);
    }

    public void setData(SocioParticipeDto data) {
        fieldCUIT.setText(data.getCuit());
        fieldRazonSocial.setText(data.getRazonSocial());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fieldFecha.setText(sdf.format(data.getFecha()));
        fieldActividadPrincipal.setText(data.getActividadPrincipal());
        fieldDomicilio.setText(data.getDireccion());
        fieldTelefono.setText(data.getTelefono());
        fieldMail.setText(data.getMail());
        lblSocioId.setText(String.valueOf(data.getSocioId()));

        LineaDeCreditoDto lineaDeCreditoDto = data.getLineaCredito();
        if (lineaDeCreditoDto != null) {
            fieldLineaFecha.setText(sdf.format(lineaDeCreditoDto.getFechaVigencia()));
            List<EstadoDto> estadoDtos = lineaDeCreditoDto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadoDtos.isEmpty()) {
                estadosText = estadoDtos.get(estadoDtos.size() - 1).getNombre();
            }
            fieldLineaEstado.setText(estadosText);
            fieldLineaMontoMaximo.setText(String.valueOf(lineaDeCreditoDto.getMontoMaximo()));
            fieldLineaMontoDisponible.setText(String.valueOf(lineaDeCreditoDto.getMontoDisponible()));
        }

    }

    public void getData(SocioParticipeDto data) {
        data.setCuit(fieldCUIT.getText());
        data.setRazonSocial(fieldRazonSocial.getText());
        data.setActividadPrincipal(fieldActividadPrincipal.getText());
        data.setDireccion(fieldDomicilio.getText());
        data.setTelefono(fieldTelefono.getText());
        data.setMail(fieldMail.getText());
        data.setPostulante(fieldPostulante.getSelectedItem().toString());
    }

    public boolean isModified(SocioParticipeDto data) {
        if (fieldCUIT.getText() != null ? !fieldCUIT.getText().equals(data.getCuit()) : data.getCuit() != null)
            return true;
        if (fieldRazonSocial.getText() != null ? !fieldRazonSocial.getText().equals(data.getRazonSocial()) : data.getRazonSocial() != null)
            return true;
        if (fieldActividadPrincipal.getText() != null ? !fieldActividadPrincipal.getText().equals(data.getActividadPrincipal()) : data.getActividadPrincipal() != null)
            return true;
        if (fieldDomicilio.getText() != null ? !fieldDomicilio.getText().equals(data.getDireccion()) : data.getDireccion() != null)
            return true;
        if (fieldTelefono.getText() != null ? !fieldTelefono.getText().equals(data.getTelefono()) : data.getTelefono() != null)
            return true;
        if (fieldMail.getText() != null ? !fieldMail.getText().equals(data.getMail()) : data.getMail() != null)
            return true;
        return false;
    }

    private void initTableDeuda() {

        String[] columns = new String[]{
                "DeudaID", "Monto", "Mora", "Mora Pendiente", "fecha"
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
        List<DeudaDto> deudaDtoList = socioParticipeDto.getDeudas();
        double deudaTotal = 0;
        for (DeudaDto dto : deudaDtoList) {
            Object[] o = new Object[5];
            o[0] = String.valueOf(dto.getDeudaId());
            o[1] = dto.getMonto();
            o[2] = String.valueOf(dto.getMontoMora());
            o[3] = String.valueOf(dto.getMontoPendiente());
            o[4] = sdf.format(dto.getFecha());
            model.addRow(o);
            deudaTotal += dto.getMontoMora();
        }
        DeudaTotals.setText(String.valueOf(deudaTotal));
        Deudastable = new JTable(model);

        listaDeudas.setViewportView(new JTable(model));
    }

}
