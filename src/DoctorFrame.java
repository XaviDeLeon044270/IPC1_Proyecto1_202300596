import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DoctorFrame extends JFrame{
    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 25);
    JTextField citaText;
    static DefaultTableModel horariosModelTable = new DefaultTableModel();
    int contadorCitas = 0;

    private Doctor doctor;

    public DoctorFrame(Doctor doctor) {
        this.doctor = doctor;
    }

    public void initialize (){
        JTabbedPane doctorPane = new JTabbedPane();

        if (horariosModelTable.getColumnCount() == 0) {
            horariosModelTable.addColumn("No.");
            horariosModelTable.addColumn("Horario");
        }

        JTable horariosCitasTable = new JTable(horariosModelTable);

        JPanel citasPanel = new JPanel();

        JLabel tituloLabel = new JLabel("Citas", SwingConstants.CENTER);

        JPanel asignarHorarioPanel = new JPanel();

        JLabel tituloHorarioLabel = new JLabel("Horario", SwingConstants.LEFT);
        tituloHorarioLabel.setFont(tituloFont);

        JPanel tituloHorarioPanel = new JPanel(new BorderLayout());
        tituloHorarioPanel.setOpaque(false);
        tituloHorarioPanel.add(tituloHorarioLabel, BorderLayout.WEST);
        tituloHorarioPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 0, 0));

        JLabel horarioLabel = new JLabel("Horario de citas:", SwingConstants.LEFT);
        horarioLabel.setFont(principalFont);
        horarioLabel.setPreferredSize(new Dimension(150, 40));
        horarioLabel.setMaximumSize(new Dimension(150, 40));
        horarioLabel.setMinimumSize(new Dimension(150, 40));
        JComboBox<String> horarioComboBox = new JComboBox<>(Main.horario);
        horarioComboBox.setFont(principalFont);
        horarioComboBox.setPreferredSize(new Dimension(150, 40));
        horarioComboBox.setMaximumSize(new Dimension(150, 40));
        horarioComboBox.setMinimumSize(new Dimension(150, 40));
        JButton asignarButton = new JButton("Asignar");
        asignarButton.setFont(principalFont);
        asignarButton.setPreferredSize(new Dimension(150, 40));
        asignarButton.setMaximumSize(new Dimension(150, 40));
        asignarButton.setMinimumSize(new Dimension(150, 40));
        asignarButton.setBackground(new Color(239, 246, 98));
        asignarButton.setBorderPainted(false);
        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horarioEscogido = (String) horarioComboBox.getSelectedItem();
                for (Horario horario : Main.horarios){
                    if (horario.getHorarioEscogido().equals(horarioEscogido)){
                        JOptionPane.showMessageDialog(null, "Ya fue seleccionado este horario");
                        return;
                    }
                }
                contadorCitas++;
                Horario nuevoHorario = new Horario(doctor, contadorCitas, horarioEscogido);
                Main.horarios.add(nuevoHorario);
                agregarHorarioATabla(nuevoHorario);
            }
        });

        JPanel seleccionarHorarioPanel = new JPanel();
        seleccionarHorarioPanel.setLayout(new BoxLayout(seleccionarHorarioPanel, BoxLayout.X_AXIS));
        seleccionarHorarioPanel.setOpaque(false);
        seleccionarHorarioPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        seleccionarHorarioPanel.add(horarioLabel);
        seleccionarHorarioPanel.add(horarioComboBox);
        seleccionarHorarioPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        seleccionarHorarioPanel.add(asignarButton);
        seleccionarHorarioPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JLabel horarioCitasLabel = new JLabel("Mi horario de citas:", SwingConstants.CENTER);
        horarioCitasLabel.setFont(principalFont);
        JPanel tablaHorarioPanel = new JPanel();
        tablaHorarioPanel.setLayout(new BoxLayout(tablaHorarioPanel, BoxLayout.Y_AXIS));
        tablaHorarioPanel.setBackground(new Color(98, 246, 107));
        tablaHorarioPanel.add(horarioCitasLabel);
        tablaHorarioPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        tablaHorarioPanel.add(new JScrollPane(horariosCitasTable));
        tablaHorarioPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        asignarHorarioPanel.setLayout(new BoxLayout(asignarHorarioPanel, BoxLayout.Y_AXIS));
        asignarHorarioPanel.setBackground(new Color(98, 246, 107));
        asignarHorarioPanel.add(tituloHorarioPanel);
        asignarHorarioPanel.add(seleccionarHorarioPanel);
        asignarHorarioPanel.add(tablaHorarioPanel);

        JButton editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setFont(principalFont);
        editarPerfilButton.setBackground(new Color(239, 246, 98));
        editarPerfilButton.setBorderPainted(false);
        editarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                EditarDoctorFrame editarDoctorFrame = new EditarDoctorFrame(doctor);
                editarDoctorFrame.initialize();
            }
        });


        doctorPane.addTab("Citas", citasPanel);
        doctorPane.addTab("Asignar Horario", asignarHorarioPanel);
        doctorPane.addTab("", new JPanel());
        doctorPane.setTabComponentAt(2, editarPerfilButton);

        add(doctorPane);

        setTitle("Doctor");
        setSize(800, 600);
        setVisible(true);


    }
    public static void agregarHorarioATabla(Horario horario) {
        horariosModelTable.addRow(new Object[]{horario.getContadorCitas(), horario.getHorarioEscogido()});
    }
}