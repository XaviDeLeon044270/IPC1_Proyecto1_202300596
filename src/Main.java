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
        inicializarDatos();
        SwingUtilities.invokeLater(() -> {
            IniciarSesionFrame iniciarSesionFrame = new IniciarSesionFrame();
            iniciarSesionFrame.initialize();
        });

    }
    private static void inicializarDatos() {
        Doctor doctor1 = new Doctor("Javier", "Lopez", "25", "Masculino", "234", "Pediatra", "65498721", "20254");
        Doctor doctor2 = new Doctor("Nicole", "Garcia", "37", "Femenino", "345", "Oftalmologo", "78565432", "20375");
        Doctor doctor3 = new Doctor("Roberto", "Navarro", "30", "Masculino", "456", "Dermatologo", "54658754", "20456");

        doctores.add(doctor1);
        doctores.add(doctor2);
        doctores.add(doctor3);
        AdminFrame.doctoresModelTable.addRow(new Object[]{doctor1.getCodigo(), doctor1.getNombres(), doctor1.getApellidos(), doctor1.getEdad(), doctor1.getGenero(), doctor1.getEspecialidad(), doctor1.getTelefono()});
        AdminFrame.doctoresModelTable.addRow(new Object[]{doctor2.getCodigo(), doctor2.getNombres(), doctor2.getApellidos(), doctor2.getEdad(), doctor2.getGenero(), doctor2.getEspecialidad(), doctor2.getTelefono()});
        AdminFrame.doctoresModelTable.addRow(new Object[]{doctor3.getCodigo(), doctor3.getNombres(), doctor3.getApellidos(), doctor3.getEdad(), doctor3.getGenero(), doctor3.getEspecialidad(), doctor3.getTelefono()});
    }
}