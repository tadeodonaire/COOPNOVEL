package pe.edu.upc.coopnovel.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pe.edu.upc.coopnovel.entities.Role;

import java.time.LocalDate;
import java.util.List;

public class UsuariosDTO {
    private int idUsuario;

    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String usNombre;

    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String usApellido;


    private LocalDate usFecNacimiento;


    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String usCorreo;

    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
    private String username;

    @NotNull(message = "El nombre de la aplicación no puede ser NULL")
    private String password;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUsEnable() {
        return usEnable;
    }

    public void setUsEnable(Boolean usEnable) {
        this.usEnable = usEnable;
    }

}
