package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoles;

    private String role;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuarios;

    public Roles() {
    }

    public Roles(int idRoles, String role, Usuarios usuarios) {
        this.idRoles = idRoles;
        this.role = role;
        this.usuarios = usuarios;
    }

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

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
