package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Usuarios;

import java.time.LocalDate;

public class SuscripcionesDTO {

    private int idSuscripcion;

    private LocalDate susFechaInicio;

    private Usuarios usuarios;

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public LocalDate getSusFechaInicio() {
        return susFechaInicio;
    }

    public void setSusFechaInicio(LocalDate susFechaInicio) {
        this.susFechaInicio = susFechaInicio;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
