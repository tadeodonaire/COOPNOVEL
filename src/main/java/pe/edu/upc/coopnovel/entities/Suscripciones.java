package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Suscripciones")
public class Suscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuscripcion;

    @Column(name = "susFechaInicio", nullable = false)
    private LocalDate susFechaInicio;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuarios;

    public Suscripciones() {
    }

    public Suscripciones(int idSuscripcion, LocalDate susFechaInicio, Usuarios usuarios) {
        this.idSuscripcion = idSuscripcion;
        this.susFechaInicio = susFechaInicio;
        this.usuarios = usuarios;
    }

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public LocalDate getSusFechaInicio() {
        return susFechaInicio;
    }

    public void setSusFechaInicio(LocalDate susFechaInicio) {
        this.susFechaInicio = susFechaInicio;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
