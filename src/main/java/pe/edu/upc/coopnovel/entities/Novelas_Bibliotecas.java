package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "Novelas_Bibliotecas")
public class Novelas_Bibliotecas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idnovelaBiblioteca;

    @JoinColumn(name = "Novelas_idNovela", referencedColumnName = "idNovela")
    private int Novelas_idNovela;

    @JoinColumn(name = "Biblioteca_idBiblioteca", referencedColumnName = "idBiblioteca")
    private int Biblioteca_idBiblioteca;

    public Novelas_Bibliotecas(int idnovelaBiblioteca, int novelas_idNovela, int biblioteca_idBiblioteca) {
        this.idnovelaBiblioteca = idnovelaBiblioteca;
        this.Novelas_idNovela = novelas_idNovela;
        this.Biblioteca_idBiblioteca = biblioteca_idBiblioteca;
    }

    public int getIdnovelaBiblioteca() {
        return idnovelaBiblioteca;
    }
    public void setIdnovelaBiblioteca(int idnovelaBiblioteca) {this.idnovelaBiblioteca = idnovelaBiblioteca;}
    public int getNovelas_idNovela() {
        return Novelas_idNovela;
    }
}
