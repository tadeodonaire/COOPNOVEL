package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idComentario;
    @Column(name="comContenido", length=500, nullable=false)
    private String comContenido;
    @Column(name="comFecha", nullable=false)
    private LocalDate comFecha;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name="idCapitulo")
    private Capitulos capitulo;

    public Comentarios() {
    }

    public Comentarios(int idComentario, String comContenido, LocalDate comFecha, Usuarios usuario, Capitulos capitulo) {
        this.idComentario = idComentario;
        this.comContenido = comContenido;
        this.comFecha = comFecha;
        this.usuario = usuario;
        this.capitulo = capitulo;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComContenido() {
        return comContenido;
    }

    public void setComContenido(String comContenido) {
        this.comContenido = comContenido;
    }

    public LocalDate getComFecha() {
        return comFecha;
    }

    public void setComFecha(LocalDate comFecha) {
        this.comFecha = comFecha;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Capitulos getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulos capitulo) {
        this.capitulo = capitulo;
    }
}


