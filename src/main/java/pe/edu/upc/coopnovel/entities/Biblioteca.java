package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name="Biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBiblioteca")
    private int idBiblioteca;
    @Column(name="bibNombre",length = 50,nullable = false)
    private String bibNombre;
    @ManyToMany
    @JoinTable(
            name = "novelas_bibliotecas",
            joinColumns = @JoinColumn(name = "idBiblioteca"),
            inverseJoinColumns = @JoinColumn(name = "idNovela")
    )
    private List<Novelas> novelas;
    public Biblioteca() {
    }
    public Biblioteca(int idBiblioteca, String bibNombre) {
        this.idBiblioteca = idBiblioteca;
        this.bibNombre = bibNombre;
    }
    public int getIdBiblioteca() {return idBiblioteca;}
    public void setIdBiblioteca(int idBiblioteca) {this.idBiblioteca = idBiblioteca;}
    public String getBibNombre() {return bibNombre;}
    public void setBibNombre(String bibNombre) {this.bibNombre = bibNombre;}
    public List<Novelas> getNovelas() {return novelas;}
    public void setNovelas(List<Novelas> novelas) {this.novelas = novelas;}
}
