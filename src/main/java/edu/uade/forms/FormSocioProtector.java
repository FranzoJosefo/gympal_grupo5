package edu.uade.forms;

import edu.uade.DTO.*;
import edu.uade.controllers.SocioController;
import edu.uade.enums.SegmentoSocio;
import edu.uade.enums.SocioEstado;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.enums.TipoPostulante;
import edu.uade.models.Aporte;
import edu.uade.models.SocioEmpresa;
import edu.uade.models.SocioProtector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormSocioProtector extends JDialog {
    private SocioProtectorDto socioProtectorDto;
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
    private JScrollPane scrollPaneTableAcciones;
    private JScrollPane scrollPaneTableAccionistas;
    private JLabel lblsocioID;
    private JTextField fieldFechaSocioProtector;
    private JScrollPane scrollPaneTableAportes;
    private JTable tableEstados;
    private String socioId;
    private FormSocioProtector self;
    private OnFormCloseCallback onFormCloseCallback;

    public FormSocioProtector(Window owner, String socioId, OnFormCloseCallback onFormCloseCallback) {
        super(owner);
        this.socioId = socioId;
        this.onFormCloseCallback = onFormCloseCallback;
        this.setContentPane(contentPane);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonCancel);
        loadDto();

        initDefaultListeners();
        initFieldTamanioEmpresa();
        initFieldSegmentoSocio();
        initFieldPostulante();
        initTableEstados();
        initTableAcciones();
        initTableAccionistas();
        initTableAportes();
    }

    private void loadDto() {

        socioProtectorDto = new SocioProtectorDto();
        List<SocioEmpresa> socios = SocioController.INSTANCE.getSocios();
        int newSocioId = socios.get(socios.size() - 1).getSocioId()+1;
        socioProtectorDto.setSocioId(newSocioId);
        socioProtectorDto.setFecha(new Date());
        socioProtectorDto.setPostulante(TipoPostulante.POSTULANTE_PROTECTOR.name());
        socioProtectorDto.getEstados().getEstados().add(new EstadoDto(new Date(), SocioEstado.INGRESADO.name()));

        if (this.socioId != null && !this.socioId.isEmpty())
        {
            SocioEmpresa model = SocioController.INSTANCE.getSocio(Integer.parseInt(this.socioId));
            if (model != null && model instanceof SocioProtector) socioProtectorDto = ((SocioProtector) model).toDto();
        }

        this.setData(socioProtectorDto);

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
        fieldTamanioEmpresa.setSelectedItem(socioProtectorDto.getTamanioEmpresa());

        fieldTamanioEmpresa.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    TamanioEmpresa seleccion = TamanioEmpresa.valueOf(String.valueOf(fieldTamanioEmpresa.getSelectedItem()));
                    socioProtectorDto.setTamanioEmpresa(seleccion);
                    System.out.println("Selección de tamaño empresa: " + socioProtectorDto.getTamanioEmpresa());
                }
            }
        });
    }

    private void initFieldSegmentoSocio() {

        fieldSegmentoSocio.setModel(new DefaultComboBoxModel<>(SegmentoSocio.values()));

        fieldSegmentoSocio.setSelectedItem(socioProtectorDto.getSegmentoSocio());

        fieldSegmentoSocio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    SegmentoSocio seleccion = SegmentoSocio.valueOf(String.valueOf(fieldSegmentoSocio.getSelectedItem()));
                    socioProtectorDto.setSegmentoSocio(seleccion);
                    System.out.println("Selección de segmento socio: " + socioProtectorDto.getSegmentoSocio());
                }
            }
        });
    }

    private void initFieldPostulante() {

        fieldPostulante.setModel(new DefaultComboBoxModel<>(TipoPostulante.values()));

        fieldPostulante.setSelectedItem(TipoPostulante.valueOf(socioProtectorDto.getPostulante().toUpperCase()));

        fieldPostulante.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    TipoPostulante seleccion = TipoPostulante.valueOf(String.valueOf(fieldPostulante.getSelectedItem()));
                    socioProtectorDto.setPostulante(seleccion.toString()); // TODO Cambiar model para que use el enum de postulante
                    System.out.println("Selección de segmento socio: " + socioProtectorDto.getPostulante());
                }
            }
        });
    }
    private void initTableEstados(){

        String[] columns = new String[] {
                "Fecha", "Estado"
        };

        final Class[] columnClass = new Class[] {
                String.class, String.class
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
        };

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<EstadoDto> estados = socioProtectorDto.getEstados().getEstados();
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

        List<AccionDto> accionDtoList = socioProtectorDto.getAcciones();
        if(accionDtoList != null ){
            for (AccionDto dto : accionDtoList) {
                Object[] o = new Object[3];
                o[0] = String.valueOf(dto.getAccionId());
                o[1] = dto.getTipoAccionista();
                o[2] = String.valueOf(dto.getPrecio());
                model.addRow(o);
            }
        }

        scrollPaneTableAcciones.setViewportView(new JTable(model));
    }

    private void initTableAccionistas() {

        String[] columns = new String[]{
                "Id", "CUIT", "Razon Social", "Participacion %", "Tipo de accionistas"
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

        List<AccionistaDto> accionistaDtoList = socioProtectorDto.getAccionistas();
        if(accionistaDtoList != null) {
            for (AccionistaDto dto : accionistaDtoList) {
                Object[] o = new Object[5];
                o[0] = String.valueOf(dto.getAccionistaId());
                o[1] = String.valueOf(dto.getCuit());
                o[2] = String.valueOf(dto.getRazonSocial());
                o[3] = String.valueOf(dto.getParticipacionPorcentaje());
                o[4] = String.valueOf(dto.getTipoAccionista());
                model.addRow(o);
            }
        }

        scrollPaneTableAccionistas.setViewportView(new JTable(model));
    }

    private void initTableAportes() {

        String[] columns = new String[]{
                "Id", "Monto", "Fecha"
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

        List<AporteDto> aporteDtoList = socioProtectorDto.getAportes();
        if(aporteDtoList != null){
            for (AporteDto dto : aporteDtoList) {
                Object[] o = new Object[3];
                o[0] = String.valueOf(dto.getAporteID());
                o[1] = String.valueOf(dto.getFecha());
                o[2] = String.valueOf(dto.getMonto());
                model.addRow(o);
            }
        }

        scrollPaneTableAportes.setViewportView(new JTable(model));
    }

    private void onOK() {
        if (isModified(socioProtectorDto)) {
            if (socioId != null && !socioId.isEmpty()) {
                SocioEmpresa socio = SocioController.INSTANCE.getSocio(Integer.parseInt(socioId));
                SocioController.INSTANCE.getSocios().remove(socio);
            }
            this.getData(socioProtectorDto);
            if(!socioProtectorDto.getCuit().isEmpty() && !socioProtectorDto.getRazonSocial().isEmpty()) {
                if (!(SocioController.INSTANCE.esSocioAccionista(socioProtectorDto.getCuit()))) {
                    SocioController.INSTANCE.getSocios().add(new SocioProtector(socioProtectorDto));
                    onFormCloseCallback.onModelUpdated();
                    dispose();
                } else {
                    DialogError error = new DialogError("El socio ya es accionista de una empresa participe.");
                    error.setVisible(true);
                }
            }
        }

    }

    private void onCancel() {
        onFormCloseCallback.onModelUpdated();
        dispose();
    }

    public void setData(SocioProtectorDto data) {
        fieldCUIT.setText(data.getCuit());
        fieldRazonSocial.setText(data.getRazonSocial());
        fieldActividadPrincipal.setText(data.getActividadPrincipal());
        fieldDomicilio.setText(data.getDireccion());
        fieldTelefono.setText(data.getTelefono());
        fieldMail.setText(data.getMail());
        lblsocioID.setText(String.valueOf(data.getSocioId()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fieldFechaSocioProtector.setText(sdf.format(data.getFecha()));
    }

    public void getData(SocioProtectorDto data) {
        data.setCuit(fieldCUIT.getText());
        data.setRazonSocial(fieldRazonSocial.getText());
        data.setActividadPrincipal(fieldActividadPrincipal.getText());
        data.setDireccion(fieldDomicilio.getText());
        data.setTelefono(fieldTelefono.getText());
        data.setMail(fieldMail.getText());
        data.setPostulante(fieldPostulante.getSelectedItem().toString());
    }

    public boolean isModified(SocioProtectorDto data) {
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




}
