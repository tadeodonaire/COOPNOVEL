package pe.edu.upc.coopnovel.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.time.LocalDate;

public class ReunionesDTO {
    private int idReunion;
    private String reuTema;
    private LocalDate reuFecha;
    private String reuLink;
    private UserSecurityDTO organizadorReu;
    private UserSecurityDTO participanteReu;

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

    public UserSecurityDTO getParticipanteReu() {
        return participanteReu;
    }

    public void setParticipanteReu(UserSecurityDTO participanteReu) {
        this.participanteReu = participanteReu;
    }

    public UserSecurityDTO getOrganizadorReu() {
        return organizadorReu;
    }

    public void setOrganizadorReu(UserSecurityDTO organizadorReu) {
        this.organizadorReu = organizadorReu;
    }
}
