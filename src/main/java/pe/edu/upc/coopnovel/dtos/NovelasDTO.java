package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Proyectos;

public class NovelasDTO {

    private int idNovelas;

    private String novTitulo;

    private String novResumen;

    private String novGenero;

    private Proyectos proyectos;

    public int getIdNovelas() {
        return idNovelas;
    }

    public void setIdNovelas(int idNovelas) {
        this.idNovelas = idNovelas;
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

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }
}
