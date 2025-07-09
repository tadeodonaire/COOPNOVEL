package pe.edu.upc.coopnovel.dtos;

public class SuscripcionesQueryDTO {
    private  int idUsuario;
    private  String nombre;
    private String apellido;
    private int suscriptores;
    private String novelas;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(int suscriptores) {
        this.suscriptores = suscriptores;
    }

    public String getNovelas() {
        return novelas;
    }

    public void setNovelas(String novelas) {
        this.novelas = novelas;
    }
}
