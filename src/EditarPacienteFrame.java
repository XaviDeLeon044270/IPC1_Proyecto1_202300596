import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditarPacienteFrame extends JFrame{

    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JTextField nombresText, apellidosText, contrasenaText;
    JLabel tituloLabel;
    JSpinner edadSpinner;
    JComboBox<String> generoComboBox;
    private Paciente paciente;

    public EditarPacienteFrame(Paciente paciente) {
        this.paciente = paciente;
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
        edadSpinner = new JSpinner(new SpinnerNumberModel(18, 18, 110, 1));
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
                
                if (nombres.isEmpty() || apellidos.isEmpty() || edad.isEmpty() || genero.equals("Seleccione la opción") || contrasena.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                    return;
                }
                else{
                    actualizarPaciente();
                }
                
            }
        });

        tituloLabel = new JLabel("Editar Cuenta de Paciente", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JPanel tituloPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloPanel.setOpaque(false);
        tituloPanel.add(tituloLabel);
        tituloPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(5,1,5,5));
        formularioPanel.setOpaque(false);
        formularioPanel.add(nombresLabel);
        formularioPanel.add(nombresText);
        formularioPanel.add(apellidosLabel);
        formularioPanel.add(apellidosText);
        formularioPanel.add(edadLabel);
        formularioPanel.add(edadSpinner);
        formularioPanel.add(generoLabel);
        formularioPanel.add(generoComboBox);
        formularioPanel.add(contrasenaLabel);
        formularioPanel.add(contrasenaText);
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

        setTitle("Editar Cuenta de Paciente");
        setSize(300, 300);
        setMinimumSize(new Dimension(450, 450));
        setVisible(true);

        nombresText.setText(paciente.getNombres());
        apellidosText.setText(paciente.getApellidos());
        edadSpinner.setValue(paciente.getEdad());
        generoComboBox.setSelectedItem(paciente.getGenero());
        contrasenaText.setText(paciente.getContrasena());
    }

    private void actualizarPaciente() {
        
        String nombres = nombresText.getText();
        String apellidos = apellidosText.getText();
        String edad = edadSpinner.getValue().toString();
        String genero = generoComboBox.getSelectedItem().toString();
        String contrasena = contrasenaText.getText();

        paciente.setNombres(nombres);
        paciente.setApellidos(apellidos);
        paciente.setEdad(edad);
        paciente.setGenero(genero);
        paciente.setContrasena(contrasena);

        
        JOptionPane.showMessageDialog(null, "Se han actualizado los datos del paciente.");

        AdminFrame.actualizarPacienteEnTabla(paciente);

        dispose();
    }

}

