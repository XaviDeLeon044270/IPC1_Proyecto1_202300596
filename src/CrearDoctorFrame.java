import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class CrearDoctorFrame extends JFrame{
    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JTextField nombresText, apellidosText, contrasenaText;
    JLabel tituloLabel;
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
        JSpinner edadSpinner = new JSpinner(new SpinnerNumberModel(23, 23, 110, 1));
        edadSpinner.setFont(principalFont);
        JLabel generoLabel = new JLabel("Genero", SwingConstants.LEFT);
        generoLabel.setFont(principalFont);
        String[] generos = {"Seleccione la opción", "Masculino", "Femenino"};
        JComboBox<String> generoComboBox = new JComboBox<>(generos);
        generoComboBox.setFont(principalFont);
        JLabel contrasenaLabel = new JLabel("Contraseña", SwingConstants.LEFT);
        contrasenaLabel.setFont(principalFont);
        contrasenaText = new JPasswordField();
        contrasenaText.setFont(principalFont);
        JLabel especialidadLabel = new JLabel("Especialidad", SwingConstants.LEFT);
        especialidadLabel.setFont(principalFont);
        String[] especialidad = {"Seleccione la opción", "Cardiólogo", "Pediatra", "Urologo", "Ginecologo", "Oftalmologo", "Dermatologo", "Oncologo", "Neurologo", "Psiquiatra"};
        JComboBox<String> especialidadComboBox = new JComboBox<>(especialidad);
        JLabel telefonoLabel = new JLabel("Telefono", SwingConstants.LEFT);
        telefonoLabel.setFont(principalFont);
        JSpinner telefonoSpinner = new JSpinner(new SpinnerNumberModel(11111111, 11111111, 99999999, 1));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(telefonoSpinner, "#");
        telefonoSpinner.setEditor(editor);
        telefonoSpinner.setFont(principalFont);

        JButton crearCuentaButton = new JButton("Crear Cuenta");
        crearCuentaButton.setFont(principalFont);
        crearCuentaButton.setBackground(new Color(239, 246, 98));
        crearCuentaButton.setBorderPainted(false);
        crearCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres = nombresText.getText();
                String apellidos = apellidosText.getText();
                String edad = edadSpinner.getValue().toString();
                String genero = (String) generoComboBox.getSelectedItem();
                String contrasena = new String(contrasenaText.getText());
                String especialidad = (String) especialidadComboBox.getSelectedItem();
                String telefono = telefonoSpinner.getValue().toString();
                
                if (nombres.isEmpty() || apellidos.isEmpty() || genero.equals("Seleccione la opción") || contrasena.length() == 0 || especialidad.equals("Seleccione la opción")) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                    return;
                }
                else{
                    IniciarSesionFrame.codigoDoctor = IniciarSesionFrame.codigoDoctor + 1;
                    String codigoString = Integer.toString(IniciarSesionFrame.codigoDoctor);
                    JOptionPane.showMessageDialog(null, "Este es el código de paciente: \n\n" + codigoString);
                    Doctor nuevoDoctor = new Doctor(nombres, apellidos, edad, genero, contrasena, especialidad, telefono, codigoString);
                    Main.doctores.add(nuevoDoctor);
                    AdminFrame.agregarDoctorATabla(nuevoDoctor);
                    dispose();
                    return;
                }
                
            }
        });

        tituloLabel = new JLabel("Crear Cuenta de Doctor", SwingConstants.CENTER);
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
        botonesPanel.setLayout(new GridLayout(1,1,5,-10));
        botonesPanel.setOpaque(false);
        botonesPanel.add(crearCuentaButton);
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.setBackground(new Color(98, 246, 107));
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        principalPanel.add(tituloPanel, BorderLayout.NORTH);
        principalPanel.add(formularioPanel, BorderLayout.CENTER);
        principalPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(principalPanel);

        setTitle("Crear Cuenta de Doctor");
        setSize(300, 300);
        setMinimumSize(new Dimension(700, 400));
        setVisible(true);
    }

}
