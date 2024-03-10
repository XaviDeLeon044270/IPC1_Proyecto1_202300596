import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class AdminFrame extends JFrame{
    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JLabel tituloLabel;
    public static boolean eliminarPaciente = false, eliminarDoctor = false, eliminarProducto = false;
    public static DefaultTableModel pacientesModelTable = new DefaultTableModel();
    public static DefaultTableModel doctoresModelTable = new DefaultTableModel();
    public static DefaultTableModel productosModelTable = new DefaultTableModel();
    public static JTable pacientesTable = new JTable(pacientesModelTable);
    public static JTable doctoresTable = new JTable(doctoresModelTable);
    public static JTable productosTable = new JTable(productosModelTable);
    public static String especialidad1, especialidad2, especialidad3;
    public static int cantidad1, cantidad2, cantidad3;
    public static DefaultCategoryDataset datosGrafica;
    public static ChartPanel graficaChartPanel;
    
    public void initialize (){
        JTabbedPane adminPane = new JTabbedPane();

        JPanel pacientesPanel = new JPanel(new BorderLayout());   

        tituloLabel = new JLabel("Pacientes", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JButton crearPacienteButton = new JButton("Crear paciente");
        crearPacienteButton.setFont(principalFont);
        crearPacienteButton.setBackground(new Color(239, 246, 98));
        crearPacienteButton.setPreferredSize(new Dimension(250, 50));
        crearPacienteButton.setMaximumSize(new Dimension(250, 50));
        crearPacienteButton.setMinimumSize(new Dimension(250, 50));
        crearPacienteButton.setBorderPainted(false);
        crearPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CrearPacienteFrame crearPacienteFrame = new CrearPacienteFrame();
                crearPacienteFrame.initialize();
            }
        });
                
        JButton actualizarPacienteButton = new JButton("Actualizar paciente");
        actualizarPacienteButton.setFont(principalFont);
        actualizarPacienteButton.setBackground(new Color(239, 246, 98));
        actualizarPacienteButton.setPreferredSize(new Dimension(250, 50));
        actualizarPacienteButton.setMaximumSize(new Dimension(250, 50));
        actualizarPacienteButton.setMinimumSize(new Dimension(250, 50));
        actualizarPacienteButton.setBorderPainted(false);
        actualizarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminarPaciente = false;
                CodigoPacienteFrame codigoPacienteFrame = new CodigoPacienteFrame();
                codigoPacienteFrame.initialize();
            }
        });

        JButton eliminarPacienteButton = new JButton("Eliminar paciente");
        eliminarPacienteButton.setFont(principalFont);
        eliminarPacienteButton.setBackground(new Color(239, 246, 98));
        eliminarPacienteButton.setPreferredSize(new Dimension(250, 50));
        eliminarPacienteButton.setMaximumSize(new Dimension(250, 50));
        eliminarPacienteButton.setMinimumSize(new Dimension(250, 50));
        eliminarPacienteButton.setBorderPainted(false);
        eliminarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminarPaciente = true;
                CodigoPacienteFrame codigoPacienteFrame = new CodigoPacienteFrame();
                codigoPacienteFrame.initialize();
            }
        });

        JPanel tituloPacientePanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloPacientePanel.setOpaque(false);
        tituloPacientePanel.add(tituloLabel);
        tituloPacientePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        

        JPanel botonesPacientePanel = new JPanel();
        botonesPacientePanel.setLayout(new BoxLayout(botonesPacientePanel, BoxLayout.Y_AXIS));
        botonesPacientePanel.setOpaque(false);
        botonesPacientePanel.add(crearPacienteButton);
        botonesPacientePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        botonesPacientePanel.add(actualizarPacienteButton);
        botonesPacientePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        botonesPacientePanel.add(eliminarPacienteButton);

        pacientesPanel.setLayout(new BorderLayout());
        pacientesPanel.setBackground(new Color(98, 246, 107));
        pacientesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pacientesPanel.add(tituloPacientePanel, BorderLayout.NORTH);
        pacientesPanel.add(new JScrollPane(pacientesTable), BorderLayout.WEST);
        pacientesPanel.add(botonesPacientePanel, BorderLayout.EAST);

        JPanel doctoresPanel = new JPanel(new BorderLayout());

        tituloLabel = new JLabel("Doctores", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JButton crearDoctorButton = new JButton("Crear doctor");
        crearDoctorButton.setFont(principalFont);
        crearDoctorButton.setBackground(new Color(239, 246, 98));
        crearDoctorButton.setPreferredSize(new Dimension(250, 50));
        crearDoctorButton.setMaximumSize(new Dimension(250, 50));
        crearDoctorButton.setMinimumSize(new Dimension(250, 50));
        crearDoctorButton.setBorderPainted(false);
        crearDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CrearDoctorFrame crearDoctorFrame = new CrearDoctorFrame();
                actualizarGraficaEspecialidades();
                crearDoctorFrame.initialize();
            }
        });
        
        JButton actualizarDoctorButton = new JButton("Actualizar doctor");
        actualizarDoctorButton.setFont(principalFont);
        actualizarDoctorButton.setBackground(new Color(239, 246, 98));
        actualizarDoctorButton.setPreferredSize(new Dimension(250, 50));
        actualizarDoctorButton.setMaximumSize(new Dimension(250, 50));
        actualizarDoctorButton.setMinimumSize(new Dimension(250, 50));
        actualizarDoctorButton.setBorderPainted(false);
        actualizarDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CodigoDoctorFrame codigoDoctorFrame = new CodigoDoctorFrame();
                codigoDoctorFrame.initialize();
            }
        });

        JButton eliminarDoctorButton = new JButton("Eliminar doctor");
        eliminarDoctorButton.setFont(principalFont);
        eliminarDoctorButton.setBackground(new Color(239, 246, 98));
        eliminarDoctorButton.setPreferredSize(new Dimension(250, 50));
        eliminarDoctorButton.setMaximumSize(new Dimension(250, 50));
        eliminarDoctorButton.setMinimumSize(new Dimension(250, 50));
        eliminarDoctorButton.setBorderPainted(false);
        eliminarDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminarDoctor = true;
                CodigoDoctorFrame codigoDoctorFrame = new CodigoDoctorFrame();
                codigoDoctorFrame.initialize();
            }
        });

        JPanel tituloDoctorPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloDoctorPanel.setOpaque(false);
        tituloDoctorPanel.add(tituloLabel);
        tituloDoctorPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel botonesDoctorPanel = new JPanel();
        botonesDoctorPanel.setLayout(new BoxLayout(botonesDoctorPanel, BoxLayout.Y_AXIS));
        botonesDoctorPanel.setOpaque(false);
        botonesDoctorPanel.add(crearDoctorButton);
        botonesDoctorPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        botonesDoctorPanel.add(actualizarDoctorButton);
        botonesDoctorPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        botonesDoctorPanel.add(eliminarDoctorButton);
        botonesDoctorPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        long cantidadCardiologos = cantidadDoctoresPorEspecialidad("Cardiólogo"), cantidadPediatras = cantidadDoctoresPorEspecialidad("Pediatra"), cantidadUrologos = cantidadDoctoresPorEspecialidad("Urologo");
        long cantidadGinecologos = cantidadDoctoresPorEspecialidad("Ginecologo"), cantidadOftalmologos = cantidadDoctoresPorEspecialidad("Oftalmologo"), cantidadDermatologos = cantidadDoctoresPorEspecialidad("Dermatologo");
        long cantidadNeurologos = cantidadDoctoresPorEspecialidad("Neurologo"), cantidadPsiquiatras = cantidadDoctoresPorEspecialidad("Psiquiatra");
        Map<String, Long> cantidadPorEspecialidad = new HashMap<>();
        cantidadPorEspecialidad.put("Cardiólogo", cantidadCardiologos);
        cantidadPorEspecialidad.put("Pediatra", cantidadPediatras);
        cantidadPorEspecialidad.put("Urologo", cantidadUrologos);
        cantidadPorEspecialidad.put("Ginecologo", cantidadGinecologos);
        cantidadPorEspecialidad.put("Oftalmologo", cantidadOftalmologos);
        cantidadPorEspecialidad.put("Dermatologo", cantidadDermatologos);
        cantidadPorEspecialidad.put("Neurologo", cantidadNeurologos);
        cantidadPorEspecialidad.put("Psiquiatra", cantidadPsiquiatras);

        List<Map.Entry<String, Long>> lista = new ArrayList<>(cantidadPorEspecialidad.entrySet());
        lista.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        
        especialidad1 = lista.get(0).getKey();
        especialidad2 = lista.get(1).getKey();
        especialidad3 = lista.get(2).getKey();

        cantidad1 = lista.get(0).getValue().intValue();
        cantidad2 = lista.get(1).getValue().intValue();
        cantidad3 = lista.get(2).getValue().intValue();

        datosGrafica = new DefaultCategoryDataset();
        datosGrafica.setValue(cantidad1, "Especialidad", especialidad1);
        datosGrafica.setValue(cantidad2, "Especialidad", especialidad2);
        datosGrafica.setValue(cantidad3, "Especialidad", especialidad3);

        JFreeChart graficaEspecialidades = ChartFactory.createBarChart("Especialidades", "Especialidad", "Cantidad", datosGrafica, PlotOrientation.VERTICAL, false, true, false);

        graficaChartPanel = new ChartPanel(graficaEspecialidades);
        graficaChartPanel.setMouseWheelEnabled(true);
        graficaChartPanel.setPreferredSize(new Dimension(200, 200));

        JPanel graficaDoctorPanel = new JPanel(new GridLayout(2,0,0,1));
        graficaDoctorPanel.setOpaque(false);
        graficaDoctorPanel.add(botonesDoctorPanel);
        graficaDoctorPanel.add(graficaChartPanel);

        pack();
        repaint();

        doctoresPanel.setLayout(new BorderLayout());
        doctoresPanel.setBackground(new Color(98, 246, 107));
        doctoresPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));               
        doctoresPanel.add(tituloDoctorPanel, BorderLayout.NORTH);
        doctoresPanel.add(new JScrollPane(doctoresTable), BorderLayout.WEST);
        doctoresPanel.add(graficaDoctorPanel, BorderLayout.EAST);


        JPanel productosPanel = new JPanel(new BorderLayout());

        


        tituloLabel = new JLabel("Productos", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JButton crearProductoButton = new JButton("Crear producto");
        crearProductoButton.setFont(principalFont);
        crearProductoButton.setBackground(new Color(239, 246, 98));
        crearProductoButton.setPreferredSize(new Dimension(250, 50));
        crearProductoButton.setMaximumSize(new Dimension(250, 50));
        crearProductoButton.setMinimumSize(new Dimension(250, 50));
        crearProductoButton.setBorderPainted(false);
        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CrearProductoFrame crearProductoFrame = new CrearProductoFrame();
                crearProductoFrame.initialize();
            }
        });
        
        JButton actualizarProductoButton = new JButton("Actualizar producto");
        actualizarProductoButton.setFont(principalFont);
        actualizarProductoButton.setBackground(new Color(239, 246, 98));
        actualizarProductoButton.setPreferredSize(new Dimension(250, 50));
        actualizarProductoButton.setMaximumSize(new Dimension(250, 50));
        actualizarProductoButton.setMinimumSize(new Dimension(250, 50));
        actualizarProductoButton.setBorderPainted(false);
        actualizarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CodigoProductoFrame codigoProductoFrame = new CodigoProductoFrame();
                codigoProductoFrame.initialize();
            }
        });

        JButton eliminarProductoButton = new JButton("Eliminar producto");
        eliminarProductoButton.setFont(principalFont);
        eliminarProductoButton.setBackground(new Color(239, 246, 98));
        eliminarProductoButton.setPreferredSize(new Dimension(250, 50));
        eliminarProductoButton.setMaximumSize(new Dimension(250, 50));
        eliminarProductoButton.setMinimumSize(new Dimension(250, 50));
        eliminarProductoButton.setBorderPainted(false);
        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                eliminarProducto = true;
                CodigoProductoFrame codigoProductoFrame = new CodigoProductoFrame();
                codigoProductoFrame.initialize();
            }
        });

        JPanel tituloProductoPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloProductoPanel.setOpaque(false);
        tituloProductoPanel.add(tituloLabel);
        tituloProductoPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        

        JPanel botonesProductoPanel = new JPanel();
        botonesProductoPanel.setLayout(new BoxLayout(botonesProductoPanel, BoxLayout.Y_AXIS));
        botonesProductoPanel.setOpaque(false);
        botonesProductoPanel.add(crearProductoButton);
        botonesProductoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        botonesProductoPanel.add(actualizarProductoButton);
        botonesProductoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        botonesProductoPanel.add(eliminarProductoButton);
        botonesProductoPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        productosPanel.setLayout(new BorderLayout());
        productosPanel.setBackground(new Color(98, 246, 107));
        productosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));               
        productosPanel.add(tituloProductoPanel, BorderLayout.NORTH);
        productosPanel.add(new JScrollPane(productosTable), BorderLayout.WEST);
        productosPanel.add(botonesProductoPanel, BorderLayout.EAST);
        

        adminPane.addTab("Pacientes", pacientesPanel);
        adminPane.addTab("Doctores", doctoresPanel);
        adminPane.addTab("Productos", productosPanel);

        add(adminPane);

        setTitle("Administrador");
        setSize(300, 300);
        setMinimumSize(new Dimension(800, 600));
        setVisible(true);
    }

    public static void agregarPacienteATabla(Paciente paciente) {
        pacientesModelTable.addRow(new Object[]{paciente.getNombres(), paciente.getApellidos(), paciente.getEdad(), paciente.getGenero(), paciente.getContrasena(), paciente.getCodigo()});
    }
    
    public static void actualizarPacienteEnTabla(Paciente paciente) {
        
        int fila = -1;
        for (int i = 0; i < pacientesModelTable.getRowCount(); i++) {
            if (pacientesModelTable.getValueAt(i, 5).equals(paciente.getCodigo())) {
                fila = i;
                break;
            }
        }
    
        if (fila != -1) {
            pacientesModelTable.setValueAt(paciente.getNombres(), fila, 0);
            pacientesModelTable.setValueAt(paciente.getApellidos(), fila, 1);
            pacientesModelTable.setValueAt(paciente.getEdad(), fila, 2);
            pacientesModelTable.setValueAt(paciente.getGenero(), fila, 3);
            pacientesModelTable.setValueAt(paciente.getContrasena(), fila, 4);
            pacientesModelTable.setValueAt(paciente.getCodigo(), fila, 5);
        }
    }

    public static void agregarDoctorATabla(Doctor doctor) {
        doctoresModelTable.addRow(new Object[]{doctor.getNombres(), doctor.getApellidos(), doctor.getEdad(), doctor.getGenero(), doctor.getContrasena(), doctor.getEspecialidad(), doctor.getTelefono(), doctor.getCodigo()});
    }

    public static void actualizarDoctorEnTabla(Doctor doctor) {
        
        int fila = -1;
        for (int i = 0; i < doctoresModelTable.getRowCount(); i++) {
            if (doctoresModelTable.getValueAt(i, 7).equals(doctor.getCodigo())) {
                fila = i;
                break;
            }
        }
    
        if (fila != -1) {
            doctoresModelTable.setValueAt(doctor.getNombres(), fila, 0);
            doctoresModelTable.setValueAt(doctor.getApellidos(), fila, 1);
            doctoresModelTable.setValueAt(doctor.getEdad(), fila, 2);
            doctoresModelTable.setValueAt(doctor.getGenero(), fila, 3);
            doctoresModelTable.setValueAt(doctor.getContrasena(), fila, 4);
            doctoresModelTable.setValueAt(doctor.getEspecialidad(), fila, 5);
            doctoresModelTable.setValueAt(doctor.getTelefono(), fila, 6);
            doctoresModelTable.setValueAt(doctor.getCodigo(), fila, 7);
            
        }
    }

    public static void agregarProductoATabla(Producto producto) {
        productosModelTable.addRow(new Object[]{producto.getNombre(), producto.getCantidad(), producto.getDescripcion(), producto.getPrecio(), producto.getCodigo()});
    }

    public static void actualizarProductoEnTabla(Producto producto) {
        
        int fila = -1;
        for (int i = 0; i < productosModelTable.getRowCount(); i++) {
            if (productosModelTable.getValueAt(i, 4).equals(producto.getCodigo())) {
                fila = i;
                break;
            }
        }
    
        if (fila != -1) {
            productosModelTable.setValueAt(producto.getNombre(), fila, 0);
            productosModelTable.setValueAt(producto.getCantidad(), fila, 1);
            productosModelTable.setValueAt(producto.getDescripcion(), fila, 2);
            productosModelTable.setValueAt(producto.getPrecio(), fila, 3);
            productosModelTable.setValueAt(producto.getCodigo(), fila, 4);
        }
    }

    public static long cantidadDoctoresPorEspecialidad(String especialidadBuscada) {
        return Main.doctores.stream().filter(doctor -> doctor.getEspecialidad().equals(especialidadBuscada)).count();
    }

    public void actualizarGraficaEspecialidades() {
        
        datosGrafica.clear();

        cantidad1 = (int) cantidadDoctoresPorEspecialidad(especialidad1);
        cantidad2 = (int) cantidadDoctoresPorEspecialidad(especialidad2);
        cantidad3 = (int) cantidadDoctoresPorEspecialidad(especialidad3);
    
        datosGrafica.setValue(cantidad1, "Especialidad", especialidad1);
        datosGrafica.setValue(cantidad2, "Especialidad", especialidad2);
        datosGrafica.setValue(cantidad3, "Especialidad", especialidad3);
    
        graficaChartPanel.repaint();
    }
}
