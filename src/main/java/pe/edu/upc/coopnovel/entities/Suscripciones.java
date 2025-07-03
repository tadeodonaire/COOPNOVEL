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
    @JoinColumn(name = "idSuscriptor")
    private Usuarios suscriptor;

    @ManyToOne
    @JoinColumn(name = "idSuscrito")
    private Usuarios suscrito;

    public Suscripciones() {
    }

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Usuarios getSuscrito() {
        return suscrito;
    }

    public void setSuscrito(Usuarios suscrito) {
        this.suscrito = suscrito;
    }

    public Usuarios getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(Usuarios suscriptor) {
        this.suscriptor = suscriptor;
    }

    public LocalDate getSusFechaInicio() {
        return susFechaInicio;
    }

    public void setSusFechaInicio(LocalDate susFechaInicio) {
        this.susFechaInicio = susFechaInicio;
    }
}
