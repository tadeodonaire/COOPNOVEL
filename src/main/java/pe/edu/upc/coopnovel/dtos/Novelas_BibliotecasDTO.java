package pe.edu.upc.coopnovel.dtos;

import jakarta.persistence.JoinColumn;

public class Novelas_BibliotecasDTO {
    private int idnovelaBiblioteca;
    private int Novelas_idNovela;
    private int Biblioteca_idBiblioteca;

    public int getIdnovelaBiblioteca() {
        return idnovelaBiblioteca;
    }

    public void setIdnovelaBiblioteca(int idnovelaBiblioteca) {
        this.idnovelaBiblioteca = idnovelaBiblioteca;
    }

    public int getNovelas_idNovela() {
        return Novelas_idNovela;
    }

    public void setNovelas_idNovela(int novelas_idNovela) {
        Novelas_idNovela = novelas_idNovela;
    }

    public int getBiblioteca_idBiblioteca() {
        return Biblioteca_idBiblioteca;
    }

    public void setBiblioteca_idBiblioteca(int biblioteca_idBiblioteca) {
        Biblioteca_idBiblioteca = biblioteca_idBiblioteca;
    }
}
