package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

@Entity
@Table(name="NovelasBibliotecas")
public class NovelasBibliotecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNovelaBiblioteca;

    @ManyToOne
    @JoinColumn(name = "idNovela",nullable = false)
    private Novelas novelas;

    @ManyToOne
    @JoinColumn(name = "idBiblioteca",nullable = false)
    private Biblioteca biblioteca;

    public NovelasBibliotecas() {
    }

    public NovelasBibliotecas(int idNovelaBiblioteca, Novelas novelas, Biblioteca biblioteca) {
        this.idNovelaBiblioteca = idNovelaBiblioteca;
        this.novelas = novelas;
        this.biblioteca = biblioteca;
    }

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