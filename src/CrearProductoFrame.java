import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CrearProductoFrame extends JFrame{

    final private Font principalFont = new Font("Times New Roman", Font.PLAIN, 20);
    final private Font tituloFont = new Font("Times New Roman", Font.BOLD, 35);
    JTextField nombreText, descripcionText;
    JLabel tituloLabel;

    public void initialize(){
        
        JLabel nombreLabel = new JLabel("Nombre", SwingConstants.LEFT);
        nombreLabel.setFont(principalFont);
        nombreText = new JTextField();
        nombreText.setFont(principalFont);
        JLabel cantidadLabel = new JLabel("Cantidad", SwingConstants.LEFT);
        cantidadLabel.setFont(principalFont);
        JSpinner cantidadSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        cantidadSpinner.setFont(principalFont);
        JLabel descripcionLabel = new JLabel("Descripción", SwingConstants.LEFT);
        descripcionLabel.setFont(principalFont);
        descripcionText =  new JTextField();
        descripcionText.setFont(principalFont);
        JLabel precioLabel = new JLabel("Precio", SwingConstants.LEFT);
        precioLabel.setFont(principalFont);
        JSpinner precioSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        precioSpinner.setFont(principalFont);

        JButton crearProductoButton = new JButton("Crear Producto");
        crearProductoButton.setFont(principalFont);
        crearProductoButton.setBackground(new Color(239, 246, 98));
        crearProductoButton.setBorderPainted(false);
        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreText.getText();
                String cantidad = cantidadSpinner.getValue().toString();
                String descripcion = descripcionText.getText();
                String precio = precioSpinner.getValue().toString();
                
                if (nombre.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                    return;
                }
                for (Producto producto : Main.productos){
                    if (producto.getNombre().equals(nombre)){
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
                        return;
                    }
                }
                IniciarSesionFrame.codigoProducto = IniciarSesionFrame.codigoProducto + 1;
                String codigoString = Integer.toString(IniciarSesionFrame.codigoProducto);
                JOptionPane.showMessageDialog(null, "Este es el código de paciente: \n\n" + codigoString);
                Producto nuevoProducto = new Producto(nombre, cantidad, descripcion, precio, codigoString);
                Main.productos.add(nuevoProducto);
                AdminFrame.agregarProductoATabla(nuevoProducto);
                dispose();
                return;
                
            }
        });

        tituloLabel = new JLabel("Crear Producto", SwingConstants.CENTER);
        tituloLabel.setFont(tituloFont);

        JPanel tituloPanel = new JPanel(new GridLayout(0,1,0,1));        
        tituloPanel.setOpaque(false);
        tituloPanel.add(tituloLabel);
        tituloPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(4,1,5,5));
        formularioPanel.setOpaque(false);
        formularioPanel.add(nombreLabel);
        formularioPanel.add(nombreText);
        formularioPanel.add(cantidadLabel);
        formularioPanel.add(cantidadSpinner);
        formularioPanel.add(descripcionLabel);
        formularioPanel.add(descripcionText);
        formularioPanel.add(precioLabel);
        formularioPanel.add(precioSpinner);
        formularioPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1,1,5,-15));
        botonesPanel.setOpaque(false);
        botonesPanel.add(crearProductoButton);
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.setBackground(new Color(98, 246, 107));
        principalPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        principalPanel.add(tituloPanel, BorderLayout.NORTH);
        principalPanel.add(formularioPanel, BorderLayout.CENTER);
        principalPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(principalPanel);

        setTitle("Crear Producto");
        setSize(300, 300);
        setMinimumSize(new Dimension(450, 400));
        setVisible(true);
    }

}
