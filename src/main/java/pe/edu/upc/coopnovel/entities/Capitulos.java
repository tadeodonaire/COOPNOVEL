package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Capitulos")
public class Capitulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCapitulo;

    @Column(name = "capTitulo",length = 30,nullable = false)
    private String capTitulo;

    @Column(name = "capContenido",length = 10000000, nullable = false)
    private String capContenido;

    @ManyToOne
    @JoinColumn(name = "idNovela",nullable = false)
    private Novelas novelas;



    public Capitulos() {
    }

    public Capitulos(int idCapitulo, String capTitulo, String capContenido, Novelas novelas) {
        this.idCapitulo = idCapitulo;
        this.capTitulo = capTitulo;
        this.capContenido = capContenido;
        this.novelas = novelas;
    }

    public int getIdCapitulo() {
        return idCapitulo;
    }

    public void setIdCapitulo(int idCapitulo) {
        this.idCapitulo = idCapitulo;
    }

    public String getCapTitulo() {
        return capTitulo;
    }

    public void setCapTitulo(String capTitulo) {
        this.capTitulo = capTitulo;
    }

    public String getCapContenido() {
        return capContenido;
    }

    public void setCapContenido(String capContenido) {
        this.capContenido = capContenido;
    }

    public Novelas getNovelas() {
        return novelas;
    }

    public void setNovelas(Novelas novelas) {
        this.novelas = novelas;
    }

}
