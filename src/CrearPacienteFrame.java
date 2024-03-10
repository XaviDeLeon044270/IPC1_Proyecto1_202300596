import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CrearPacienteFrame extends JFrame{

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
        JSpinner edadSpinner = new JSpinner(new SpinnerNumberModel(18, 18, 110, 1));
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
                
                if (nombres.isEmpty() || apellidos.isEmpty() || edad.isEmpty() || genero.equals("Seleccione la opción") || contrasena.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                    return;
                }
                for (Paciente paciente : Main.pacientes){
                    if (paciente.getNombres().equals(nombres) && paciente.getApellidos().equals(apellidos)){
                        JOptionPane.showMessageDialog(null, "Ya existe un paciente con esos nombres y apellidos");
                        return;
                    }
                }
                Main.codigoPaciente = Main.codigoPaciente + 1;
                String codigoString = Integer.toString(Main.codigoPaciente);
                JOptionPane.showMessageDialog(null, "Este es el código de paciente: \n\n" + codigoString);
                Paciente nuevoPaciente = new Paciente(nombres, apellidos, edad, genero, contrasena, codigoString);
                Main.pacientes.add(nuevoPaciente);
                AdminFrame.agregarPacienteATabla(nuevoPaciente);
                dispose();
                return;
            }
        });

        tituloLabel = new JLabel("Crear Cuenta de Paciente", SwingConstants.CENTER);
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

        setTitle("Crear Cuenta de Paciente");
        setSize(300, 300);
        setMinimumSize(new Dimension(450, 450));
        setVisible(true);
    }

}
