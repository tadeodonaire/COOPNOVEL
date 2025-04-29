package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Usuarios;

public class RolesDTO {
    private int idRoles;
    private String role;
    private Usuarios user;

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
}
