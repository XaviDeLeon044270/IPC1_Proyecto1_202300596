import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Paciente> pacientes = new ArrayList<>();
    public static List<Doctor> doctores = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            AdminFrame adminFrame = new AdminFrame();
            adminFrame.initialize();
            Frame frame = new Frame();
            frame.setVisible(true);
        });

    }
}