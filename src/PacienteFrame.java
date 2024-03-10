import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PacienteFrame extends JFrame{
    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 25);
    JTextField citaText;
    private static DefaultTableModel citasModelTable = new DefaultTableModel();
    private static int contadorCitas = 0;

    private Paciente paciente;

    public PacienteFrame(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public void initialize (){
        JTabbedPane pacientePane = new JTabbedPane();

        JPanel solicitarCitaPanel = new JPanel(new BorderLayout());

        JLabel citaLabel = new JLabel("Motivo de la cita:", SwingConstants.CENTER);
        citaLabel.setFont(principalFont);
        citaLabel.setPreferredSize(new Dimension(150, 40));
        citaLabel.setMaximumSize(new Dimension(150, 40));
        citaLabel.setMinimumSize(new Dimension(150, 40));
        citaText = new JTextField();
        citaText.setFont(principalFont);
        citaText.setPreferredSize(new Dimension(700, 80));
        citaText.setMaximumSize(new Dimension(700, 80));
        citaText.setMinimumSize(new Dimension(700, 80));
        
        JLabel especialidadLabel = new JLabel("Especialidad", SwingConstants.LEFT);
        especialidadLabel.setFont(principalFont);
        especialidadLabel.setPreferredSize(new Dimension(150, 40));
        especialidadLabel.setMaximumSize(new Dimension(150, 40));
        especialidadLabel.setMinimumSize(new Dimension(150, 40));

        ArrayList<String> especialidadesDoctores = new ArrayList<>();
        especialidadesDoctores.add("Seleccione una especialidad");
            for (Doctor doctor : Main.doctores) {
                String especialidad = doctor.getEspecialidad();
                if (!especialidadesDoctores.contains(especialidad)) {
                    especialidadesDoctores.add(especialidad);
                }
            }

        String[] especialidadArray = especialidadesDoctores.toArray(new String[0]);

        JComboBox<String> especialidadComboBox = new JComboBox<>(especialidadArray);
        especialidadComboBox.setFont(principalFont);
        especialidadComboBox.setPreferredSize(new Dimension(150, 40));
        especialidadComboBox.setMaximumSize(new Dimension(150, 40));
        especialidadComboBox.setMinimumSize(new Dimension(150, 40));
        
        JLabel doctorLabel = new JLabel("Doctor", SwingConstants.LEFT);
        doctorLabel.setFont(principalFont);
        doctorLabel.setPreferredSize(new Dimension(150, 40));
        doctorLabel.setMaximumSize(new Dimension(150, 40));
        doctorLabel.setMinimumSize(new Dimension(150, 40));

        ArrayList<String> nombresDoctores = new ArrayList<>();
        nombresDoctores.add("Seleccione un doctor");
        String[] nombresDoctoresArray = nombresDoctores.toArray(new String[0]);

        JComboBox<String> doctorComboBox = new JComboBox<>(nombresDoctoresArray);
        doctorComboBox.setFont(principalFont);
        doctorComboBox.setPreferredSize(new Dimension(150, 40));
        doctorComboBox.setMaximumSize(new Dimension(150, 40));
        doctorComboBox.setMinimumSize(new Dimension(150, 40));

        JButton mostrarDoctoresButton = new JButton("Mostrar doctores");
        mostrarDoctoresButton.setFont(principalFont);
        mostrarDoctoresButton.setPreferredSize(new Dimension(200, 40));
        mostrarDoctoresButton.setMaximumSize(new Dimension(200, 40));
        mostrarDoctoresButton.setMinimumSize(new Dimension(200, 40));
        mostrarDoctoresButton.setBackground(new Color(239, 246, 98));
        mostrarDoctoresButton.setBorderPainted(false);
        mostrarDoctoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String especialidadSeleccionada = (String)especialidadComboBox.getSelectedItem();
                nombresDoctores.clear();
                for (Doctor doctor : Main.doctores) {
                    if (doctor.getEspecialidad().equals(especialidadSeleccionada)) {
                        String nombreDoctor = "Dr(a). " + doctor.getNombres() + " " + doctor.getApellidos();
                        nombresDoctores.add(nombreDoctor);
                    }
                }
                String [] nombresDoctoresArray = nombresDoctores.toArray(new String[0]); 
                doctorComboBox.setFont(principalFont);
                doctorComboBox.setModel(new DefaultComboBoxModel<>(nombresDoctoresArray));
            }
        });

        ArrayList<String> horariosDoctores = new ArrayList<>();
        horariosDoctores.add("Seleccione un horario");
        String[] horariosDoctoresArray = nombresDoctores.toArray(new String[0]);

        JComboBox<String> horaComboBox = new JComboBox<>(horariosDoctoresArray);
        horaComboBox.setPreferredSize(new Dimension(150, 40));
        horaComboBox.setMaximumSize(new Dimension(150, 40));
        horaComboBox.setMinimumSize(new Dimension(150, 40));

        JButton mostrarHorariosButton = new JButton("Mostrar horarios");
        mostrarHorariosButton.setFont(principalFont);
        mostrarHorariosButton.setPreferredSize(new Dimension(200, 40));
        mostrarHorariosButton.setMaximumSize(new Dimension(200, 40));
        mostrarHorariosButton.setMinimumSize(new Dimension(200, 40));
        mostrarHorariosButton.setBackground(new Color(239, 246, 98));
        mostrarHorariosButton.setBorderPainted(false);
        mostrarHorariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String doctorSeleccionado = (String) doctorComboBox.getSelectedItem();
                horariosDoctores.clear();
                for (Horario horario : Main.horarios) {
                    if (("Dr(a). " + horario.getDoctor().getNombres() + " " + horario.getDoctor().getApellidos()).equals(doctorSeleccionado)) {
                        String horarioEscogido = horario.getHorarioEscogido();
                        horariosDoctores.add(horarioEscogido);
                    }
                }
                String [] horariosDoctoresArray = horariosDoctores.toArray(new String[0]);                                       
                horaComboBox.setFont(principalFont);
                horaComboBox.setModel(new DefaultComboBoxModel<>(horariosDoctoresArray));
            }
        });
        
        JLabel horarioLabel = new JLabel("Seleccionar horario de cita", SwingConstants.LEFT);
        horarioLabel.setFont(principalFont);
        JLabel fechaLabel = new JLabel("Fecha", SwingConstants.LEFT);
        fechaLabel.setFont(principalFont);
        fechaLabel.setPreferredSize(new Dimension(150, 40));
        fechaLabel.setMaximumSize(new Dimension(150, 40));
        fechaLabel.setMinimumSize(new Dimension(150, 40));
        String[] fecha = {"Seleccione fecha", "15/03/2024", "16/03/2024", "17/03/2024", "18/03/2024", "19/03/2024"};
        JComboBox<String> fechaComboBox = new JComboBox<>(fecha);
        fechaComboBox.setPreferredSize(new Dimension(150, 40));
        fechaComboBox.setMaximumSize(new Dimension(150, 40));
        fechaComboBox.setMinimumSize(new Dimension(150, 40));
        JLabel horaLabel = new JLabel("Hora", SwingConstants.LEFT);
        horaLabel.setFont(principalFont);
        horaLabel.setPreferredSize(new Dimension(150, 40));
        horaLabel.setMaximumSize(new Dimension(150, 40));
        horaLabel.setMinimumSize(new Dimension(150, 40));
        
        

        JButton generarCitaButton = new JButton("Generar Cita");
        generarCitaButton.setFont(principalFont);
        generarCitaButton.setPreferredSize(new Dimension(200, 50));
        generarCitaButton.setMaximumSize(new Dimension(200, 50));
        generarCitaButton.setMinimumSize(new Dimension(200, 50));
        generarCitaButton.setBackground(new Color(239, 246, 98));
        generarCitaButton.setBorderPainted(false);
        generarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (citaText.getText().equals("") || especialidadComboBox.getSelectedItem().equals("Seleccione una especialidad") || doctorComboBox.getSelectedItem().equals("Seleccione un doctor") || horaComboBox.getSelectedItem().equals("Seleccione un horario") || fechaComboBox.getSelectedItem().equals("Seleccione fecha")) {
                    JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
                    return;
                }
                contadorCitas++;
                citasModelTable.addRow(new Object[]{contadorCitas, "Pendiente", fechaComboBox.getSelectedItem(), horaComboBox.getSelectedItem()});
            }
        });

        JPanel citaLabelPanel = new JPanel();
        citaLabelPanel.setLayout(new BorderLayout());     
        citaLabelPanel.setOpaque(false);
        citaLabelPanel.add(citaLabel, BorderLayout.WEST);

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setOpaque(false);
        boxPanel.add(citaText);
        boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        JPanel especialidadPanel = new JPanel();
        especialidadPanel.setLayout(new BoxLayout(especialidadPanel, BoxLayout.X_AXIS));
        especialidadPanel.setOpaque(false);
        especialidadPanel.add(especialidadLabel);
        especialidadPanel.add(especialidadComboBox);
        especialidadPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        especialidadPanel.add(mostrarDoctoresButton);

        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.X_AXIS));
        doctorPanel.setBackground(new Color(98, 246, 107));
        doctorPanel.add(doctorLabel);
        doctorPanel.add(doctorComboBox);
        doctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        doctorPanel.add(mostrarHorariosButton);

        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new BorderLayout()); 
        tituloPanel.setOpaque(false);
        tituloPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        tituloPanel.add(horarioLabel, BorderLayout.WEST);

        JPanel inferiorPanel = new JPanel();
        inferiorPanel.setLayout(new BoxLayout(inferiorPanel, BoxLayout.X_AXIS));
        inferiorPanel.setBackground(new Color(98, 246, 107));
        inferiorPanel.add(fechaLabel);
        inferiorPanel.add(fechaComboBox);
        inferiorPanel.add(Box.createRigidArea(new Dimension(75, 0)));
        inferiorPanel.add(horaLabel);
        inferiorPanel.add(horaComboBox);
        inferiorPanel.add(Box.createRigidArea(new Dimension(75, 0)));
        inferiorPanel.add(generarCitaButton);

        solicitarCitaPanel.setLayout(new BoxLayout(solicitarCitaPanel, BoxLayout.Y_AXIS));
        solicitarCitaPanel.setBackground(new Color(98, 246, 107));
        solicitarCitaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        solicitarCitaPanel.add(citaLabelPanel);
        solicitarCitaPanel.add(boxPanel);
        solicitarCitaPanel.add(especialidadPanel);
        solicitarCitaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        solicitarCitaPanel.add(doctorPanel);
        solicitarCitaPanel.add(tituloPanel);
        solicitarCitaPanel.add(inferiorPanel);

        JPanel estadoCitasPanel = new JPanel(new BorderLayout());

        JLabel historialCitasLabel = new JLabel("Historial de citas:", SwingConstants.LEFT);
        historialCitasLabel.setFont(tituloFont);

        if (citasModelTable.getColumnCount() == 0) {
            citasModelTable.addColumn("No.");
            citasModelTable.addColumn("Estado");
            citasModelTable.addColumn("Fecha");
            citasModelTable.addColumn("Hora");
        }

        JTable citasTable = new JTable(citasModelTable);

        estadoCitasPanel.setLayout(new GridLayout(2,1,5,5));
        estadoCitasPanel.setBackground(new Color(98, 246, 107));
        estadoCitasPanel.add(historialCitasLabel, BorderLayout.NORTH);
        estadoCitasPanel.add(new JScrollPane(citasTable), BorderLayout.CENTER);
        estadoCitasPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel farmaciaLabel = new JLabel("Nuestros productos disponibles en farmacia", SwingConstants.CENTER);
        farmaciaLabel.setFont(tituloFont);

        JPanel productosPanel = new JPanel(new GridLayout(2,0,0,1));
        productosPanel.setBackground(new Color(98, 246, 107));
        productosPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        productosPanel.add(farmaciaLabel, BorderLayout.NORTH);
        JPanel botonesPanel = new JPanel(new GridLayout(4,10,0,1));
        botonesPanel.setBackground(new Color(98, 246, 107));
        for (Producto producto : Main.productos){
            JButton productoButton = new JButton(producto.getNombre());
            productoButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            productoButton.setFont(principalFont);
            productoButton.setBackground(new Color(239, 246, 98));
            productoButton.setBorderPainted(false);
            productoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Producto: " + producto.getNombre() + "\nPrecio: Q" + producto.getPrecio() + ".00" + "\nDescripción: " + producto.getDescripcion());
                }
            });
            botonesPanel.add(productoButton);
        }
        productosPanel.add(botonesPanel, BorderLayout.CENTER);

        JButton editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setFont(principalFont);
        editarPerfilButton.setBackground(new Color(239, 246, 98));
        editarPerfilButton.setBorderPainted(false);
        editarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                EditarPacienteFrame editarPacienteFrame = new EditarPacienteFrame(paciente);
                editarPacienteFrame.initialize();
            }
        });

        pacientePane.addTab("Solicitar Cita", solicitarCitaPanel);
        pacientePane.addTab("Estado de Cita", estadoCitasPanel);
        pacientePane.addTab("Farmacia", productosPanel);
        pacientePane.addTab("", new JPanel());
        pacientePane.setTabComponentAt(3, editarPerfilButton);

        add(pacientePane);

        setTitle("Paciente");
        setSize(300, 300);
        setMinimumSize(new Dimension(1000, 500));
        setVisible(true);
    }
    
}
