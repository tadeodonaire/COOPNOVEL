package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBiblioteca")
    private int idBiblioteca;
    @Column(name="bibNombre",length = 50,nullable = false)
    private String bibNombre;
    public Biblioteca() {
    }
    public Biblioteca(int idBiblioteca, String bibNombre) {
        this.idBiblioteca = idBiblioteca;
        this.bibNombre = bibNombre;
    }
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
}
