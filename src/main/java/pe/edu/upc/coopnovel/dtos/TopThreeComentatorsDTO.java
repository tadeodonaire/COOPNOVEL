package pe.edu.upc.coopnovel.dtos;

public class TopThreeComentatorsDTO {
    private int idUsuario;
    private String usNombre;
    private String usApellido;
    private int totalComentarios;

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

    public int getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(int totalComentarios) {
        this.totalComentarios = totalComentarios;
    }
}
