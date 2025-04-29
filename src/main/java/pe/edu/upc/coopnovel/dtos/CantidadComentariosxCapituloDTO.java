package pe.edu.upc.coopnovel.dtos;

import java.time.LocalDate;

public class CantidadComentariosxCapituloDTO {
    private String usNombre;
    private String capTitulo;
    private LocalDate comFecha;
    private int cantidadComentarios;

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }

    public String getCapTitulo() {
        return capTitulo;
    }

    public void setCapTitulo(String capTitulo) {
        this.capTitulo = capTitulo;
    }

    public LocalDate getComFecha() {
        return comFecha;
    }

    public void setComFecha(LocalDate comFecha) {
        this.comFecha = comFecha;
    }

    public int getCantidadComentarios() {
        return cantidadComentarios;
    }

    public void setCantidadComentarios(int cantidadComentarios) {
        this.cantidadComentarios = cantidadComentarios;
    }
}
