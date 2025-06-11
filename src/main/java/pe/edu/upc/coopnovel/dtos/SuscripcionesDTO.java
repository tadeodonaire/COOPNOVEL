package pe.edu.upc.coopnovel.dtos;



import java.time.LocalDate;

public class SuscripcionesDTO {

    private int idSuscripcion;

    private LocalDate susFechaInicio;

    private UserSecurityDTO usuarios;

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

    public UserSecurityDTO getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UserSecurityDTO usuarios) {
        this.usuarios = usuarios;
    }
}
