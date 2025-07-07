package pe.edu.upc.coopnovel.dtos;


import pe.edu.upc.coopnovel.entities.Role;

import java.time.LocalDate;


public class UserSecurityDTO {
    private int idUsuario;
    private String usNombre;
    private String usApellido;
    private LocalDate usFecNacimiento;
    private String usCorreo;
    private String username;
    private Boolean usEnable;
    private Role role;

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

    public LocalDate getUsFecNacimiento() {
        return usFecNacimiento;
    }

    public void setUsFecNacimiento(LocalDate usFecNacimiento) {
        this.usFecNacimiento = usFecNacimiento;
    }

    public String getUsCorreo() {
        return usCorreo;
    }

    public void setUsCorreo(String usCorreo) {
        this.usCorreo = usCorreo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getUsEnable() {
        return usEnable;
    }

    public void setUsEnable(Boolean usEnable) {
        this.usEnable = usEnable;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
