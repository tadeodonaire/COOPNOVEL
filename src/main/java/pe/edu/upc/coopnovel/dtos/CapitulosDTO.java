package pe.edu.upc.coopnovel.dtos;


import pe.edu.upc.coopnovel.entities.Descargas;

public class CapitulosDTO {
    private int idCapitulo;
    private String capTitulo;
    private String capContenido;
    private NovelasDTO novelas;
    private DescargasDTO descargas;


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

    public NovelasDTO getNovelas() {
        return novelas;
    }

    public void setNovelas(NovelasDTO novelas) {
        this.novelas = novelas;
    }

    public DescargasDTO getDescargas() {
        return descargas;
    }

    public void setDescargas(DescargasDTO descargas) {
        this.descargas = descargas;
    }
}
