package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;

public class Novelas_Bibliotecas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idnovelaBiblioteca;

    @JoinColumn(name = "Novelas_idNovela", referencedColumnName = "idNovela")
    private int Novelas_idNovela;

    @JoinColumn(name = "Biblioteca_idBiblioteca", referencedColumnName = "idBiblioteca")
    private int Biblioteca_idBiblioteca;

    public Novelas_Bibliotecas(int idnovelaBiblioteca, int novelas_idNovela, int biblioteca_idBiblioteca) {
        this.idnovelaBiblioteca = idnovelaBiblioteca;
        Novelas_idNovela = novelas_idNovela;
        Biblioteca_idBiblioteca = biblioteca_idBiblioteca;
    }

    public int getIdnovelaBiblioteca() {
        return idnovelaBiblioteca;
    }
    public void setIdnovelaBiblioteca(int idnovelaBiblioteca) {
        this.idnovelaBiblioteca = idnovelaBiblioteca;
    }
    public int getNovelas_idNovela() {
        return Novelas_idNovela;
    }
}
