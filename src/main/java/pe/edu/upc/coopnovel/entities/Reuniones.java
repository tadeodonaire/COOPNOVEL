package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Reuniones")
public class Reuniones {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idReunion;

    private String reuTema;
    private LocalDate reuFecha;
    private String reuLink;

    @ManyToOne
    @JoinColumn(name="id_organizador")
    private Usuarios organizadorReu;

    @ManyToOne
    @JoinColumn(name="id_participante")
    private Usuarios participanteReu;

    public Reuniones() { }

    public Reuniones(int idReunion, String reuTema, LocalDate reuFecha, String reuLink, Usuarios organizadorReu, Usuarios participanteReu) {
        this.idReunion = idReunion;
        this.reuTema = reuTema;
        this.reuFecha = reuFecha;
        this.reuLink = reuLink;
        this.organizadorReu = organizadorReu;
        this.participanteReu = participanteReu;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getReuTema() {
        return reuTema;
    }

    public void setReuTema(String reuTema) {
        this.reuTema = reuTema;
    }

    public LocalDate getReuFecha() {
        return reuFecha;
    }

    public void setReuFecha(LocalDate reuFecha) {
        this.reuFecha = reuFecha;
    }

    public String getReuLink() {
        return reuLink;
    }

    public void setReuLink(String reuLink) {
        this.reuLink = reuLink;
    }

    public Usuarios getOrganizadorReu() {
        return organizadorReu;
    }

    public void setOrganizadorReu(Usuarios organizadorReu) {
        this.organizadorReu = organizadorReu;
    }

    public Usuarios getParticipanteReu() {
        return participanteReu;
    }

    public void setParticipanteReu(Usuarios participanteReu) {
        this.participanteReu = participanteReu;
    }
}
