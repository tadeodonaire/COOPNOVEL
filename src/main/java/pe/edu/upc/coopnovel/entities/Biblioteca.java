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
    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuarios usuario;


    public Biblioteca() {
    }

    public Biblioteca(int idBiblioteca, String bibNombre, Usuarios usuario) {
        this.idBiblioteca = idBiblioteca;
        this.bibNombre = bibNombre;
        this.usuario = usuario;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
