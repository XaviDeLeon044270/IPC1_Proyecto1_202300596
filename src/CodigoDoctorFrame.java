import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CodigoDoctorFrame extends JFrame{

    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    JTextField codigoText;
    JLabel tituloLabel;

    
    public void initialize(){

        JLabel tituloLabel = new JLabel("Ingrese el código del doctor", SwingConstants.CENTER);
        tituloLabel.setFont(principalFont);

        JLabel codigoLabel = new JLabel("Código", SwingConstants.LEFT);
        codigoLabel.setFont(principalFont);
        codigoText = new JTextField();
        codigoText.setFont(principalFont);
        
        JButton ingresarCodigoButton = new JButton("Ingresar Código");
        ingresarCodigoButton.setFont(principalFont);
        ingresarCodigoButton.setBackground(new Color(239, 246, 98));
        ingresarCodigoButton.setBorderPainted(false);
        ingresarCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();
                if (codigo.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Rellena el campo de código");
                } else {
                    boolean encontrado = false;
                    for (Doctor doctor : Main.doctores) {
                        if (doctor.getCodigo().equals(codigo)){
                            encontrado = true;
                            if(AdminFrame.eliminarDoctor == true){
                                eliminarDoctor(doctor);
                                break;
                                
                            } else if (AdminFrame.eliminarDoctor == false){
                                EditarDoctorFrame actualizarDoctorFrame = new EditarDoctorFrame(doctor);
                                actualizarDoctorFrame.initialize();
                                break;
                            }
                         }
                         if (!encontrado){
                            JOptionPane.showMessageDialog(null, "Código incorrecto");
                         }                        
                    }
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
        formularioPanel.add(codigoText);
        formularioPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1,1,5,0));
        botonesPanel.setOpaque(false);
        botonesPanel.add(ingresarCodigoButton);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.setBackground(new Color(98, 246, 107));
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        principalPanel.add(tituloPanel, BorderLayout.NORTH);
        principalPanel.add(formularioPanel, BorderLayout.CENTER);
        principalPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(principalPanel);

        setTitle("Editar Cuenta de Doctor");
        setSize(400, 250);
        setMinimumSize(new Dimension(400, 250));
        setVisible(true);

    }
    public void eliminarDoctor(Doctor doctor) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar al doctor?", "Eliminar Doctor", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Doctor " + doctor.getNombres() + " " + doctor.getApellidos() + " eliminado");
            AdminFrame.doctoresModelTable.removeRow(Main.doctores.indexOf(doctor));
            Main.doctores.remove(doctor);
            
            dispose();
        }
    }
}