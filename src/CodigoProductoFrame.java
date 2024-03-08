import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CodigoProductoFrame extends JFrame{

    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    JTextField codigoText;
    JLabel tituloLabel;

    
    public void initialize(){

        JLabel tituloLabel = new JLabel("Ingrese el código del producto", SwingConstants.CENTER);
        tituloLabel.setFont(principalFont);

        JLabel codigoLabel = new JLabel("Código", SwingConstants.LEFT);
        codigoLabel.setFont(principalFont);
        codigoText = new JTextField();
        codigoText.setFont(principalFont);
        
        JButton editarCuentaButton = new JButton("Editar Producto");
        editarCuentaButton.setFont(principalFont);
        editarCuentaButton.setBackground(new Color(239, 246, 98));
        editarCuentaButton.setBorderPainted(false);
        editarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();

                boolean encontrado = false;

                for (Producto producto : Main.productos) {
                    if (producto.getCodigo().equals(codigo)){
                        EditarProductoFrame actualizarProductoFrame = new EditarProductoFrame(producto);
                        actualizarProductoFrame.initialize();
                        dispose();
                        encontrado = false;
                    }
                }
                if (!encontrado) {
                    if (codigo.isEmpty() ) {
                        JOptionPane.showMessageDialog(null, "Rellena el campo de código");
                    } 
                    else{
                        JOptionPane.showMessageDialog(null, "Código incorrecto");
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
        botonesPanel.add(editarCuentaButton);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.setBackground(new Color(98, 246, 107));
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        principalPanel.add(tituloPanel, BorderLayout.NORTH);
        principalPanel.add(formularioPanel, BorderLayout.CENTER);
        principalPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(principalPanel);

        setTitle("Editar Producto");
        setSize(400, 250);
        setMinimumSize(new Dimension(400, 250));
        setVisible(true);

    }
}
