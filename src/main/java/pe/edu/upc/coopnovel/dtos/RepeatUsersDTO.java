package pe.edu.upc.coopnovel.dtos;

public class RepeatUsersDTO {
    private int idUsuario;
    private String usNombre;
    private String usApellido;
    private int totalSuscripciones;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }

    public String getUsApellido() {
        return usApellido;
    }

    public void setUsApellido(String usApellido) {
        this.usApellido = usApellido;
    }

    public int getTotalSuscripciones() {
        return totalSuscripciones;
    }

    public void setTotalSuscripciones(int totalSuscripciones) {
        this.totalSuscripciones = totalSuscripciones;
    }
}
