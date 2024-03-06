import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CodigoPacienteFrame extends JFrame{

    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JTextField codigoText, contrasenaText;
    JLabel tituloLabel;

    public void initialize(){

        JLabel tituloLabel = new JLabel("Ingrse los datos del paciente", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JLabel codigoLabel = new JLabel("Código", SwingConstants.LEFT);
        codigoLabel.setFont(principalFont);
        codigoText = new JTextField();
        codigoText.setFont(principalFont);
        JLabel contrasenaLabel = new JLabel("Contraseña", SwingConstants.LEFT);
        contrasenaLabel.setFont(principalFont);
        contrasenaText =  new JPasswordField();
        contrasenaText.setFont(principalFont);
        
        JButton editarCuentaButton = new JButton("Editar Cuenta");
        editarCuentaButton.setFont(principalFont);
        editarCuentaButton.setBackground(new Color(239, 246, 98));
        editarCuentaButton.setBorderPainted(false);
        editarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();
                String contrasena = new String(contrasenaText.getText());
                
                
                for (Paciente paciente : Main.pacientes) {
                    if (paciente.getCodigo().equals(codigo) && paciente.getContrasena().equals(contrasena)){
                        EditarPacienteFrame actualizarPacienteFrame = new EditarPacienteFrame();
                        actualizarPacienteFrame.initialize();
                        break;
                    }
                }
                if (codigo.isEmpty() || contrasena.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                } else{
                    JOptionPane.showMessageDialog(null, "Código o contraseña incorrectos");
                }
                
            }
        });

        JPanel tituloPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloPanel.setOpaque(false);
        tituloPanel.add(tituloLabel);
        tituloPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(2,1,5,5));
        formularioPanel.setOpaque(false);
        formularioPanel.add(codigoLabel);
        formularioPanel.add(codigoText);
        formularioPanel.add(contrasenaLabel);
        formularioPanel.add(contrasenaText);
        formularioPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1,1,5,0));
        botonesPanel.setOpaque(false);
        botonesPanel.add(editarCuentaButton);
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
        setMinimumSize(new Dimension(500, 300));
        setVisible(true);

    }
}
