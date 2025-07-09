package pe.edu.upc.coopnovel.dtos;


import pe.edu.upc.coopnovel.entities.Novelas;

public class CapitulosDTO {
    private int idCapitulo;
    private String capTitulo;
    private String capContenido;
    private Novelas novelas;


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
