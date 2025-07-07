package pe.edu.upc.coopnovel.dtos;

public class EngagementPorUsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private int totalCapitulos;
    private int totalComentarios;
    private int totalDescargas;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getTotalCapitulos() {
        return totalCapitulos;
    }

    public void setTotalCapitulos(int totalCapitulos) {
        this.totalCapitulos = totalCapitulos;
    }

    public int getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(int totalComentarios) {
        this.totalComentarios = totalComentarios;
    }

    public int getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(int totalDescargas) {
        this.totalDescargas = totalDescargas;
    }
}
