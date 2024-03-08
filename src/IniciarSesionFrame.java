import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IniciarSesionFrame extends JFrame{
    
    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JTextField codigoText, contrasenaText;
    JLabel tituloLabel;
    public static int codigoPaciente = 10000, codigoDoctor = 20000, codigoProducto = 30000;

    public void initialize(){

        JLabel codigoLabel = new JLabel("Código", SwingConstants.CENTER);
        codigoLabel.setFont(principalFont);
        codigoText = new JTextField();
        codigoText.setFont(principalFont);
        JLabel contrasenaLabel = new JLabel("Contraseña", SwingConstants.CENTER);
        contrasenaLabel.setFont(principalFont);
        contrasenaText =  new JPasswordField();
        contrasenaText.setFont(principalFont);
        
        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        iniciarSesionButton.setFont(principalFont);
        iniciarSesionButton.setBackground(new Color(239, 246, 98));
        iniciarSesionButton.setBorderPainted(false);
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();
                String contrasena = new String(contrasenaText.getText());

                boolean encontrado = false;

                if(codigo.equals("123") && contrasena.equals("123")){
                    JOptionPane.showMessageDialog(null, "Bienvenido Admin. Xavi De León", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    AdminFrame adminFrame = new AdminFrame();
                    adminFrame.initialize();
                    encontrado = true;
                }

                for (Paciente paciente : Main.pacientes) {
                    if (paciente.getCodigo().equals(codigo) && paciente.getContrasena().equals(contrasena)){
                        JOptionPane.showMessageDialog(null, "Bienvenido " + paciente.getNombres() + " " + paciente.getApellidos(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                        PacienteFrame pacienteFrame = new PacienteFrame();
                        pacienteFrame.initialize();
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    if (codigo.isEmpty() || contrasena.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    } else{
                        JOptionPane.showMessageDialog(null, "Código o contraseña incorrectos");
                    }
                }

                for (Doctor doctor : Main.doctores) {
                    
                    if (doctor.getCodigo().equals(codigo) && doctor.getContrasena().equals(contrasena)){
                        JOptionPane.showMessageDialog(null, "Bienvenido Dr. " + doctor.getNombres() + " " + doctor.getApellidos(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                        AdminFrame adminFrame = new AdminFrame();
                        adminFrame.initialize();
                        encontrado = true;
                        break;
                    } 
                }
            }
        });

        JButton crearCuentaButton = new JButton("Crea una cuenta");
        crearCuentaButton.setFont(principalFont);
        crearCuentaButton.setForeground(new Color(0, 0, 250));
        crearCuentaButton.setBorderPainted(false);
        crearCuentaButton.setContentAreaFilled(false);
        crearCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CrearPacienteFrame crearPacienteFrame = new CrearPacienteFrame();
                crearPacienteFrame.initialize();
            }
        });
        ImageIcon candadoIcon = new ImageIcon("src/Lock.png");
        ImageIcon usuarioIcon = new ImageIcon("src/User.png");
        Image lockImage = candadoIcon.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        Image userImage = usuarioIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        candadoIcon = new ImageIcon(lockImage);
        usuarioIcon = new ImageIcon(userImage);
        JLabel candadoLabel = new JLabel(candadoIcon);
        JLabel usuarioLabel = new JLabel(usuarioIcon);

        tituloLabel = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JPanel tituloPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloPanel.setOpaque(false);
        tituloPanel.add(usuarioLabel, BorderLayout.AFTER_LAST_LINE);
        tituloPanel.add(tituloLabel);

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(5,1,5,5));
        formularioPanel.setOpaque(false);
        formularioPanel.add(codigoLabel);
        formularioPanel.add(codigoText);
        formularioPanel.add(contrasenaLabel);
        formularioPanel.add(contrasenaText);

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(3,2,5,5));
        botonesPanel.setOpaque(false);
        botonesPanel.add(iniciarSesionButton);
        botonesPanel.add(crearCuentaButton);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.setBackground(new Color(98, 246, 107));
        principalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));               
        principalPanel.add(candadoLabel, BorderLayout.EAST);
        principalPanel.add(tituloPanel, BorderLayout.NORTH);
        principalPanel.add(formularioPanel, BorderLayout.CENTER);        
        principalPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(principalPanel);

        setTitle("Iniciar Sesión");
        setSize(300, 300);
        setMinimumSize(new Dimension(600, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main (String[] args){
        IniciarSesionFrame frame = new IniciarSesionFrame();
        frame.initialize();
    }
    
}

