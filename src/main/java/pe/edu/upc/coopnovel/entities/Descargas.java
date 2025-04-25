package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Descarga")
public class Descargas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDescarga;

    @Column(name = "hisFecha", nullable = false)
    private LocalDate hisFecha;

    @ManyToOne
    @JoinColumn(name = "usuario_Id")
    private Usuarios user;

    public Descargas() {
    }

    public Descargas(int idDescarga, LocalDate hisFecha, Usuarios user) {
        this.idDescarga = idDescarga;
        this.hisFecha = hisFecha;
        this.user = user;
    }

    public int getIdDescarga() {
        return idDescarga;
    }

    public void setIdDescarga(int idDescarga) {
        this.idDescarga = idDescarga;
    }

    public LocalDate getHisFecha() {
        return hisFecha;
    }

    public void setHisFecha(LocalDate hisFecha) {
        this.hisFecha = hisFecha;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
}
