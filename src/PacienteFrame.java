import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PacienteFrame extends JFrame{
    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 25);
    JTextField citaText;
    static DefaultTableModel citasModelTable = new DefaultTableModel();
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
        String[] especialidad = {"Seleccione la opción", "Cardiólogo", "Pediatra", "Urologo", "Ginecologo", "Oftalmologo", "Dermatologo", "Oncologo", "Neurologo", "Psiquiatra"};
        JComboBox<String> especialidadComboBox = new JComboBox<>(especialidad);
        especialidadComboBox.setPreferredSize(new Dimension(150, 40));
        especialidadComboBox.setMaximumSize(new Dimension(150, 40));
        especialidadComboBox.setMinimumSize(new Dimension(150, 40));
        JLabel doctorLabel = new JLabel("Doctor", SwingConstants.LEFT);
        doctorLabel.setFont(principalFont);
        doctorLabel.setPreferredSize(new Dimension(150, 40));
        doctorLabel.setMaximumSize(new Dimension(150, 40));
        doctorLabel.setMinimumSize(new Dimension(150, 40));
        String[] doctor = {"Seleccione la opción", "a", "b", "c"};
        JComboBox<String> doctorComboBox = new JComboBox<>(doctor);
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
                //Hacer que se muestren los doctores de la especialidad seleccionada
            }
        });

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
                //Hacer que se muestren los horarios del doctor seleccionado
            }
        });
        
        JLabel horarioLabel = new JLabel("Seleccionar horario de cita", SwingConstants.LEFT);
        horarioLabel.setFont(principalFont);
        JLabel fechaLabel = new JLabel("Fecha", SwingConstants.LEFT);
        fechaLabel.setFont(principalFont);
        fechaLabel.setPreferredSize(new Dimension(150, 40));
        fechaLabel.setMaximumSize(new Dimension(150, 40));
        fechaLabel.setMinimumSize(new Dimension(150, 40));
        String[] fecha = {"Seleccione la opción", "a", "b", "c"};
        JComboBox<String> fechaComboBox = new JComboBox<>(fecha);
        fechaComboBox.setPreferredSize(new Dimension(150, 40));
        fechaComboBox.setMaximumSize(new Dimension(150, 40));
        fechaComboBox.setMinimumSize(new Dimension(150, 40));
        JLabel horaLabel = new JLabel("Hora", SwingConstants.LEFT);
        horaLabel.setFont(principalFont);
        horaLabel.setPreferredSize(new Dimension(150, 40));
        horaLabel.setMaximumSize(new Dimension(150, 40));
        horaLabel.setMinimumSize(new Dimension(150, 40));
        String[] hora = {"Seleccione la opción", "a", "b", "c"};
        JComboBox<String> horaComboBox = new JComboBox<>(hora);
        horaComboBox.setPreferredSize(new Dimension(150, 40));
        horaComboBox.setMaximumSize(new Dimension(150, 40));
        horaComboBox.setMinimumSize(new Dimension(150, 40));

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
                //Hacer que se genere la cita
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

        JPanel farmaciaPanel = new JPanel(new BorderLayout());

        pacientePane.addTab("Solicitar Cita", solicitarCitaPanel);
        pacientePane.addTab("Estado de Cita", estadoCitasPanel);
        pacientePane.addTab("Farmacia", farmaciaPanel);

        add(pacientePane);

        setTitle("Paciente");
        setSize(300, 300);
        setMinimumSize(new Dimension(1000, 500));
        setVisible(true);
    }
}
