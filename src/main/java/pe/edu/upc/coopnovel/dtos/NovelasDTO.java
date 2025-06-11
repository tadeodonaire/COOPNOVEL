package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Proyectos;

public class NovelasDTO {


    private int idNovela;

    private String novTitulo;

    private String novResumen;

    private String novGenero;

    private ProyectosDTO proyectos;



    public int getIdNovela() {
        return idNovela;
    }

    public void setIdNovela(int idNovela) {
        this.idNovela = idNovela;

    }

    public String getNovTitulo() {
        return novTitulo;
    }

    public void setNovTitulo(String novTitulo) {
        this.novTitulo = novTitulo;
    }

    public String getNovResumen() {
        return novResumen;
    }

    public void setNovResumen(String novResumen) {
        this.novResumen = novResumen;
    }

    public String getNovGenero() {
        return novGenero;
    }

    public void setNovGenero(String novGenero) {
        this.novGenero = novGenero;
    }

    public ProyectosDTO getProyectos() {
        return proyectos;
    }

    public void setProyectos(ProyectosDTO proyectos) {
        this.proyectos = proyectos;
    }
}
