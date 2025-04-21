package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Capitulos;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.time.LocalDate;

public class ComentariosDTO {
    private int idComentario;
    private String comContenido;
    private LocalDate comFecha;
    private Usuarios usuario;
    private Capitulos capitulo;

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
