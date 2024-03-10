
public class Cita {
    protected int numeroCita;
    protected String estado;
    protected String fecha;
    protected String hora;
    public Cita(int numeroCita, String estado, String fecha, String hora){
        this.numeroCita = numeroCita;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
    }
    public int getNumeroCita(){
        return numeroCita;
    }
    public void setNumeroCita(int numeroCita){
        this.numeroCita = numeroCita;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getHora(){
        return hora;
    }
    public void setHora(String hora){
        this.hora = hora;
    }
}

