package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Usuarios")
public class Usuarios {
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

    @Column(name = "usContrasena", length = 50, nullable = false)
    private String usContrasena;

    @Column(name = "usEnable", nullable = false)
    private Boolean usEnable;

    public Usuarios() {
    }

    public Usuarios(Boolean usEnable, String usContrasena, String usCorreo, LocalDate usFecNacimiento, String usApellido, String usNombre, int idUsuario) {
        this.usEnable = usEnable;
        this.usContrasena = usContrasena;
        this.usCorreo = usCorreo;
        this.usFecNacimiento = usFecNacimiento;
        this.usApellido = usApellido;
        this.usNombre = usNombre;
        this.idUsuario = idUsuario;
    }

    public Boolean getUsEnable() {
        return usEnable;
    }

    public void setUsEnable(Boolean usEnable) {
        this.usEnable = usEnable;
    }

    public String getUsContrasena() {
        return usContrasena;
    }

    public void setUsContrasena(String usContrasena) {
        this.usContrasena = usContrasena;
    }

    public String getUsCorreo() {
        return usCorreo;
    }

    public void setUsCorreo(String usCorreo) {
        this.usCorreo = usCorreo;
    }

    public LocalDate getUsFecNacimiento() {
        return usFecNacimiento;
    }

    public void setUsFecNacimiento(LocalDate usFecNacimiento) {
        this.usFecNacimiento = usFecNacimiento;
    }

    public String getUsApellido() {
        return usApellido;
    }

    public void setUsApellido(String usApellido) {
        this.usApellido = usApellido;
    }

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
