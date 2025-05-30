package pe.edu.upc.coopnovel.dtos;


import pe.edu.upc.coopnovel.entities.Biblioteca;
import pe.edu.upc.coopnovel.entities.Novelas;

public class NovelasBibliotecasDTO {
    private int idNovelaBiblioteca;
    private Novelas novelas;
    private Biblioteca biblioteca;

    public int getIdNovelaBiblioteca() {
        return idNovelaBiblioteca;
    }

    public void setIdNovelaBiblioteca(int idNovelaBiblioteca) {
        this.idNovelaBiblioteca = idNovelaBiblioteca;
    }

    public Novelas getNovelas() {
        return novelas;
    }

    public void setNovelas(Novelas novelas) {
        this.novelas = novelas;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
