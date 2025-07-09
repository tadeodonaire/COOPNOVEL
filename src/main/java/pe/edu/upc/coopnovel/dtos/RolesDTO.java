package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Usuarios;

public class RolesDTO {
    private Long id;
    private String rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
