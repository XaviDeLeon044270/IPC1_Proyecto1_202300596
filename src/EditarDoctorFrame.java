import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditarDoctorFrame extends JFrame{

    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JTextField nombresText, apellidosText, contrasenaText;
    JLabel tituloLabel;
    JSpinner edadSpinner, telefonoSpinner;
    JComboBox<String> generoComboBox, especialidadComboBox;
    private Doctor doctor;

    public EditarDoctorFrame(Doctor doctor) {
        this.doctor = doctor;
    }

    public void initialize(){

        JLabel nombresLabel = new JLabel("Nombres", SwingConstants.LEFT);
        nombresLabel.setFont(principalFont);
        nombresText = new JTextField();
        nombresText.setFont(principalFont);
        JLabel apellidosLabel = new JLabel("Apellidos", SwingConstants.LEFT);
        apellidosLabel.setFont(principalFont);
        apellidosText =  new JTextField();
        apellidosText.setFont(principalFont);
        JLabel edadLabel = new JLabel("Edad", SwingConstants.LEFT);
        edadLabel.setFont(principalFont);
        edadSpinner = new JSpinner(new SpinnerNumberModel(23, 23, 110, 1));
        edadSpinner.setFont(principalFont);
        JLabel generoLabel = new JLabel("Genero", SwingConstants.LEFT);
        generoLabel.setFont(principalFont);
        String[] generos = {"Seleccione la opción", "Masculino", "Femenino"};
        generoComboBox = new JComboBox<>(generos);
        generoComboBox.setFont(principalFont);
        JLabel contrasenaLabel = new JLabel("Contraseña", SwingConstants.LEFT);
        contrasenaLabel.setFont(principalFont);
        contrasenaText = new JPasswordField();
        contrasenaText.setFont(principalFont);
        JLabel especialidadLabel = new JLabel("Especialidad", SwingConstants.LEFT);
        especialidadLabel.setFont(principalFont);
        String[] especialidad = {"Seleccione la opción", "Cardiólogo", "Pediatra", "Urologo", "Ginecologo", "Oftalmologo", "Dermatologo", "Oncologo", "Neurologo", "Psiquiatra"};
        especialidadComboBox = new JComboBox<>(especialidad);
        especialidadComboBox.setFont(principalFont);
        JLabel telefonoLabel = new JLabel("Telefono", SwingConstants.LEFT);
        telefonoLabel.setFont(principalFont);
        telefonoSpinner = new JSpinner(new SpinnerNumberModel(11111111, 11111111, 99999999, 1));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(telefonoSpinner, "#");
        telefonoSpinner.setEditor(editor);
        telefonoSpinner.setFont(principalFont);

        JButton actualizarCuentaButton = new JButton("Editar Cuenta");
        actualizarCuentaButton.setFont(principalFont);
        actualizarCuentaButton.setBackground(new Color(239, 246, 98));
        actualizarCuentaButton.setBorderPainted(false);
        actualizarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres = nombresText.getText();
                String apellidos = apellidosText.getText();
                String edad = edadSpinner.getValue().toString();
                String genero = (String) generoComboBox.getSelectedItem();
                String contrasena = new String(contrasenaText.getText());
                String especialidad = (String) especialidadComboBox.getSelectedItem();
                String telefono = telefonoSpinner.getValue().toString();
                
                if (nombres.isEmpty() || apellidos.isEmpty()|| edad.isEmpty() || genero.equals("Seleccione la opción") || contrasena.length() == 0 || especialidad.equals("Seleccione la opción")|| telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                    return;
                }
                else{
                    actualizarDoctor();
                }
                
            }
        });

        tituloLabel = new JLabel("Editar Cuenta de Doctor", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JPanel tituloPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloPanel.setOpaque(false);
        tituloPanel.add(tituloLabel);
        tituloPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(4,2,5,5));
        formularioPanel.setOpaque(false);
        formularioPanel.add(nombresLabel);
        formularioPanel.add(nombresText);
        formularioPanel.add(apellidosLabel);
        formularioPanel.add(apellidosText);
        formularioPanel.add(contrasenaLabel);
        formularioPanel.add(contrasenaText);
        formularioPanel.add(generoLabel);
        formularioPanel.add(generoComboBox);
        formularioPanel.add(especialidadLabel);
        formularioPanel.add(especialidadComboBox);
        formularioPanel.add(edadLabel);
        formularioPanel.add(edadSpinner);
        formularioPanel.add(telefonoLabel);
        formularioPanel.add(telefonoSpinner);
        formularioPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1,1,5,0));
        botonesPanel.setOpaque(false);
        botonesPanel.add(actualizarCuentaButton);
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.setBackground(new Color(98, 246, 107));
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        principalPanel.add(tituloPanel, BorderLayout.NORTH);
        principalPanel.add(formularioPanel, BorderLayout.CENTER);
        principalPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(principalPanel);

        setTitle("Editar Cuenta de Doctor");
        setSize(300, 300);
        setMinimumSize(new Dimension(700, 400));
        setVisible(true);

        nombresText.setText(doctor.getNombres());
        apellidosText.setText(doctor.getApellidos());
        edadSpinner.setValue(doctor.getEdad());
        generoComboBox.setSelectedItem(doctor.getGenero());
        contrasenaText.setText(doctor.getContrasena());
        especialidadComboBox.setSelectedItem(doctor.getEspecialidad());
        telefonoSpinner.setValue(doctor.getTelefono());
    }

    private void actualizarDoctor() {
        
        String nombres = nombresText.getText();
        String apellidos = apellidosText.getText();
        String edad = edadSpinner.getValue().toString();
        String genero = generoComboBox.getSelectedItem().toString();
        String contrasena = contrasenaText.getText();
        String especialidad = especialidadComboBox.getSelectedItem().toString();
        String telefono = telefonoSpinner.getValue().toString();

        doctor.setNombres(nombres);
        doctor.setApellidos(apellidos);
        doctor.setEdad(edad);
        doctor.setGenero(genero);
        doctor.setContrasena(contrasena);
        doctor.setEspecialidad(especialidad);
        doctor.setTelefono(telefono);
        
        JOptionPane.showMessageDialog(null, "Se han actualizado los datos del doctor.");

        AdminFrame.actualizarDoctorEnTabla(doctor);

        dispose();
    }

}

