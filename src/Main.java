import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static List<Paciente> pacientes = new ArrayList<>();
    public static List<Doctor> doctores = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static String[] especialidad = {"Cardiologo", "Pediatra", "Urologo", "Ginecologo", "Oftalmologo", "Dermatologo", "Neurologo", "Psiquiatra"};
    public static String[] horario = {"7:00 - 8:00", "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00"};
    public static List<Horario> horarios = new ArrayList<>();
    public static int codigoPaciente = 10000, codigoDoctor = 20000, codigoProducto = 30000;
    public static List<Cita> citas = new ArrayList<>();
    
    public static void main(String[] args) {

        if (AdminFrame.pacientesModelTable.getColumnCount() == 0) {
            AdminFrame.pacientesModelTable.addColumn("Nombres");
            AdminFrame.pacientesModelTable.addColumn("Apellidos");
            AdminFrame.pacientesModelTable.addColumn("Edad");
            AdminFrame.pacientesModelTable.addColumn("Genero");
            AdminFrame.pacientesModelTable.addColumn("Contraseña");
            AdminFrame.pacientesModelTable.addColumn("Código");
        }

        if (AdminFrame.doctoresModelTable.getColumnCount() == 0) {
            AdminFrame.doctoresModelTable.addColumn("Nombres");
            AdminFrame.doctoresModelTable.addColumn("Apellidos");
            AdminFrame.doctoresModelTable.addColumn("Edad");
            AdminFrame.doctoresModelTable.addColumn("Genero");
            AdminFrame.doctoresModelTable.addColumn("Contraseña");
            AdminFrame.doctoresModelTable.addColumn("Especialidad");
            AdminFrame.doctoresModelTable.addColumn("Teléfono");
            AdminFrame.doctoresModelTable.addColumn("Código");
        }

        if (AdminFrame.productosModelTable.getColumnCount() == 0) {
            AdminFrame.productosModelTable.addColumn("Nombre");
            AdminFrame.productosModelTable.addColumn("Cantidad");
            AdminFrame.productosModelTable.addColumn("Descripción");
            AdminFrame.productosModelTable.addColumn("Precio");
            AdminFrame.productosModelTable.addColumn("Código");
        }

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

        AdminFrame.doctoresModelTable.addRow(new Object[]{doctor1.getNombres(), doctor1.getApellidos(), doctor1.getEdad(), doctor1.getGenero(), doctor1.getContrasena(), doctor1.getEspecialidad(), doctor1.getTelefono(), doctor1.getCodigo()});
        AdminFrame.doctoresModelTable.addRow(new Object[]{doctor2.getNombres(), doctor2.getApellidos(), doctor2.getEdad(), doctor2.getGenero(), doctor2.getContrasena(), doctor2.getEspecialidad(), doctor2.getTelefono(), doctor2.getCodigo()});
        AdminFrame.doctoresModelTable.addRow(new Object[]{doctor3.getNombres(), doctor3.getApellidos(), doctor3.getEdad(), doctor3.getGenero(), doctor3.getContrasena(), doctor3.getEspecialidad(), doctor3.getTelefono(), doctor3.getCodigo()});

        Producto producto1 = new Producto("Paracetamol", "100", "Medicamento para el dolor", "5", "30642");
        Producto producto2 = new Producto("Aspirina", "200", "Medicamento para el dolor de cabeza", "3", "30871");
        Producto producto3 = new Producto("Vendas", "50", "Para sujetar articulaciones", "15", "30985");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        AdminFrame.productosModelTable.addRow(new Object[]{producto1.getNombre(), producto1.getCantidad(), producto1.getDescripcion(), producto1.getPrecio(), producto1.getCodigo()});
        AdminFrame.productosModelTable.addRow(new Object[]{producto2.getNombre(), producto2.getCantidad(), producto2.getDescripcion(), producto2.getPrecio(), producto2.getCodigo()});
        AdminFrame.productosModelTable.addRow(new Object[]{producto3.getNombre(), producto3.getCantidad(), producto3.getDescripcion(), producto3.getPrecio(), producto3.getCodigo()});


    }
    
}