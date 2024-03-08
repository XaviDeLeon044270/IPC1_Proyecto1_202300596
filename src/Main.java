import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Paciente> pacientes = new ArrayList<>();
    public static List<Doctor> doctores = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static String[] especialidad = {"Cardiólogo", "Pediatra", "Urologo", "Ginecologo", "Oftalmologo", "Dermatologo", "Oncologo", "Neurologo", "Psiquiatra"};
    public static String[] horario = {"7:00 - 8:00", "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00"};
    public static List<Horario> horarios = new ArrayList<>();

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            IniciarSesionFrame iniciarSesionFrame = new IniciarSesionFrame();
            iniciarSesionFrame.initialize();
        });

    }
}