package pe.edu.upc.coopnovel.dtos;

public class NumeroCapituloPorNovelaDTO {
    private String novTitulo;
    private String novResumen;
    private String novGenero;
    private int novCantidadCapitulos;

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

    public int getNovCantidadCapitulos() {
        return novCantidadCapitulos;
    }

    public void setNovCantidadCapitulos(int novCantidadCapitulos) {
        this.novCantidadCapitulos = novCantidadCapitulos;
    }
}
