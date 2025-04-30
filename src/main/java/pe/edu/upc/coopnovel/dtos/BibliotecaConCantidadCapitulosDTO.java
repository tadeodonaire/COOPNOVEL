package pe.edu.upc.coopnovel.dtos;

public class BibliotecaConCantidadCapitulosDTO {
    private String bibNombre;
    private int cantidadCapitulos;

    public String getBibNombre() {
        return bibNombre;
    }

    public void setBibNombre(String bibNombre) {
        this.bibNombre = bibNombre;
    }

    public int getCantidadCapitulos() {
        return cantidadCapitulos;
    }

    public void setCantidadCapitulos(int cantidadCapitulos) {
        this.cantidadCapitulos = cantidadCapitulos;
    }
}
