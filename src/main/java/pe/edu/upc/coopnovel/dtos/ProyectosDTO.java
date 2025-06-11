package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Usuarios;

public class ProyectosDTO {

    private int idProyecto;

    private String proyTitulo;

    private String proyDescripcion;

    private UserSecurityDTO usario;

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getProyTitulo() {
        return proyTitulo;
    }

    public void setProyTitulo(String proyTitulo) {
        this.proyTitulo = proyTitulo;
    }

    public String getProyDescripcion() {
        return proyDescripcion;
    }

    public void setProyDescripcion(String proyDescripcion) {
        this.proyDescripcion = proyDescripcion;
    }

    public UserSecurityDTO getUsario() {
        return usario;
    }

    public void setUsario(UserSecurityDTO usario) {
        this.usario = usario;
    }
}
