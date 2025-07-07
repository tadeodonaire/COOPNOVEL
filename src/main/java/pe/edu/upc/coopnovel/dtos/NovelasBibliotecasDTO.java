package pe.edu.upc.coopnovel.dtos;


import pe.edu.upc.coopnovel.entities.Biblioteca;
import pe.edu.upc.coopnovel.entities.Novelas;

public class NovelasBibliotecasDTO {
    private int idNovelaBiblioteca;
    private NovelasDTO novelas;
    private Biblioteca biblioteca;

    public int getIdNovelaBiblioteca() {
        return idNovelaBiblioteca;
    }

    public void setIdNovelaBiblioteca(int idNovelaBiblioteca) {
        this.idNovelaBiblioteca = idNovelaBiblioteca;
    }

    public NovelasDTO getNovelas() {
        return novelas;
    }

    public void setNovelas(NovelasDTO novelas) {
        this.novelas = novelas;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
