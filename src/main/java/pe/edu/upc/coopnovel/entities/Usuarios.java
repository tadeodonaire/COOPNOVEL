package pe.edu.upc.coopnovel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "usNombre", length = 30, nullable = false)
    private String usNombre;

    @Column(name = "usApellido", length = 30, nullable = false)
    private String usApellido;

    @Column(name = "usFecNacimiento", nullable = false)
    private LocalDate usFecNacimiento;

    @Column(name = "usCorreo", length = 50, nullable = false, unique = true)
    private String usCorreo;

    @Column(length = 30, unique = true,nullable = false)
    private String username;

    @JsonIgnore
    @Column(name = "usContrasena",nullable = false)
    private String password;

    @Column(name = "usEnable", nullable = false)
    private Boolean usEnable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String usNombre, String usApellido, LocalDate usFecNacimiento, String usCorreo, String username, String password, Boolean usEnable) {
        this.idUsuario = idUsuario;
        this.usNombre = usNombre;
        this.usApellido = usApellido;
        this.usFecNacimiento = usFecNacimiento;
        this.usCorreo = usCorreo;
        this.username = username;
        this.password = password;
        this.usEnable = usEnable;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
