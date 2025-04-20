package pe.edu.upc.coopnovel.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Proyectos")
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;

    @Column(name = "proyTitulo", length = 50, nullable = false)
    private String proyTitulo;

    @Column(name = "proyDescripcion", length = 100, nullable = false)
    private String proyDescripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuarios usario;

    public Proyectos() {
    }

    public Proyectos(int idProyecto, String proyTitulo, String proyDescripcion, Usuarios usario) {
        this.idProyecto = idProyecto;
        this.proyTitulo = proyTitulo;
        this.proyDescripcion = proyDescripcion;
        this.usario = usario;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getProyTitulo() {
        return proyTitulo;
    }

    public void setProyTitulo(String proyTitulo) {
        this.proyTitulo = proyTitulo;
    }

    public String getProyDescripcion() {
        return proyDescripcion;
    }

    public void setProyDescripcion(String proyDescripcion) {
        this.proyDescripcion = proyDescripcion;
    }

    public Usuarios getUsario() {
        return usario;
    }

    public void setUsario(Usuarios usario) {
        this.usario = usario;
    }
}
