package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Usuarios;

public class BibliotecaDTO {
    private int idBiblioteca;
    private String bibNombre;
    private Usuarios usuario;

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getBibNombre() {
        return bibNombre;
    }

    public void setBibNombre(String bibNombre) {
        this.bibNombre = bibNombre;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
