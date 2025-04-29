package pe.edu.upc.coopnovel.dtos;

public class CapitulosDescargadosxUsuarioDTO {
    private String usNombre;
    private String novTitulo;
    private int cantidadDescargas;

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }

    public String getNovTitulo() {
        return novTitulo;
    }

    public void setNovTitulo(String novTitulo) {
        this.novTitulo = novTitulo;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }
}
