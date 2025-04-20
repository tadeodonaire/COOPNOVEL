package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Novelas")
public class Novelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNovelas;

    @Column(name = "novTitulo", length = 30, nullable = false)
    private String novTitulo;

    @Column(name = "novResumen", length = 550, nullable = false)
    private String novResumen;

    @Column(name = "novGenero", length = 50, nullable = false)
    private String novGenero;

    @ManyToOne
    @JoinColumn(name = "idProyectos")
    private Proyectos proyectos;

    public Novelas() {
    }

    public Novelas(int idNovelas, String novTitulo, String novResumen, String novGenero, Proyectos proyectos) {
        this.idNovelas = idNovelas;
        this.novTitulo = novTitulo;
        this.novResumen = novResumen;
        this.novGenero = novGenero;
        this.proyectos = proyectos;
    }

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
