package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;
@Entity
@Table(name="Correcciones")
public class CorreccionesIA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorreccionIA;

    @Column(name = "corCorrecionIA", length = 1000000000, nullable = false)
    private String corCorreccionIA;

    @OneToOne
    @JoinColumn(name = "idCapitulo")
    private Capitulos capitulos;

    public CorreccionesIA() {
    }

    public CorreccionesIA(int idCorreccionIA, String corCorreccionIA, Capitulos capitulos) {
        this.idCorreccionIA = idCorreccionIA;
        this.corCorreccionIA = corCorreccionIA;
        this.capitulos = capitulos;
    }

    public int getIdCorreccionIA() {
        return idCorreccionIA;
    }

    public void setIdCorreccionIA(int idCorreccionIA) {
        this.idCorreccionIA = idCorreccionIA;
    }

    public String getCorCorreccionIA() {
        return corCorreccionIA;
    }

    public void setCorCorreccionIA(String corCorreccionIA) {
        this.corCorreccionIA = corCorreccionIA;
    }

    public Capitulos getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Capitulos capitulos) {
        this.capitulos = capitulos;
    }
}
