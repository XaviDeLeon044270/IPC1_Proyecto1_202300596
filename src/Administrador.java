
public class Administrador extends Paciente {
    private String nombres;

    public Administrador(String codigo, String contrasena, String nombres, String edad, String genero, String apellidos) {
        super(codigo, contrasena, nombres, edad, genero, apellidos);
        this.nombres = nombres;
    }
}
