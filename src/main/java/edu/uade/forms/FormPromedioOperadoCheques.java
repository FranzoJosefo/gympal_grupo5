package edu.uade.forms;

import edu.uade.DTO.EstadoDto;
import edu.uade.DTO.OperacionChequePagareDto;
import edu.uade.DTO.OperacionCuentaCorrienteTcDto;
import edu.uade.controllers.OperacionController;
import edu.uade.controllers.SocioController;
import edu.uade.enums.TamanioEmpresa;
import edu.uade.models.SocioParticipe;
import edu.uade.utils.DateUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FormPromedioOperadoCheques extends JDialog{
    private JPanel contentPane;
    private JPanel tablePanel;
    private JScrollPane operacionesScrollPane;
    private JButton buttonBack;
    private JPanel botonera;
    private JPanel resultadoPanel;
    private JTextField promedioTextField;
    private FormPromedioOperadoCheques self;

    public FormPromedioOperadoCheques(Window owner, TamanioEmpresa tamanioEmpresa, String startDate, String endDate) {
        super(owner);
        this.setContentPane(contentPane);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        self = this;

        initDefaultListeners();
        initTableChequePagare(tamanioEmpresa);
//        initTableSociosParticipes();
//        initTableSociosProtectores();

        //TODO USE getTasaPromedioOperadoChequeByDateRangeByTamanio And SET RESULT CONSULTA 3

    }


    private void initTableChequePagare(TamanioEmpresa tamanioEmpresa) {
        List<OperacionChequePagareDto> operacionChequePagareDtoList = SocioController.INSTANCE.getAllOperacionesChequePagareDtos();

        DefaultTableModel model = getOperacionChequePagareTableModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (OperacionChequePagareDto dto : operacionChequePagareDtoList) {
            java.util.List<EstadoDto> estadosDto = dto.getEstados().getEstados();
            String estadosText = "SIN ESTADO";
            if (!estadosDto.isEmpty()) {
                estadosText = estadosDto.get(estadosDto.size() - 1).getNombre();
            }
            Object[] o = new Object[6];
            o[0] = sdf.format(dto.getFechaOperacion());
            o[1] = estadosText;
            o[2] = dto.getBanco();
            o[3] = dto.getImporteBruto();
            o[4] = tamanioEmpresa;
            o[5] = "Cuenta Corriente / Tarjeta de crédito";
            model.addRow(o);
        }
        operacionesScrollPane.setViewportView(new JTable(model));
    }

    private void initDefaultListeners() {
        buttonBack.addActionListener(new ActionListener() {
            @Override
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


    private DefaultTableModel getOperacionChequePagareTableModel() {
        String[] columns = new String[]{
                "Fecha", "Estado", "Entidad", "Importe", "Tamaño Empresa", "Tipo"
        };

        final Class[] columnClass = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class
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
