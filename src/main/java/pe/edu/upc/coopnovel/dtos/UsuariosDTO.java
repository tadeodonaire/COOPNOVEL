package pe.edu.upc.coopnovel.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class UsuariosDTO {
    private int idUsuario;
    private String usNombre;
    private String usApellido;
    private LocalDate usFecNacimiento;
    private String usCorreo;
    private String usContrasena;
    private Boolean usEnable;


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

    public String getUsContrasena() {
        return usContrasena;
    }

    public void setUsContrasena(String usContrasena) {
        this.usContrasena = usContrasena;
    }

    public Boolean getUsEnable() {
        return usEnable;
    }

    public void setUsEnable(Boolean usEnable) {
        this.usEnable = usEnable;
    }
}
