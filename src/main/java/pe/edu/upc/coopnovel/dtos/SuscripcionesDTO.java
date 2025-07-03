package pe.edu.upc.coopnovel.dtos;



import java.time.LocalDate;

public class SuscripcionesDTO {

    private int idSuscripcion;

    private LocalDate susFechaInicio;

    private UserSecurityDTO suscriptor;
    private UserSecurityDTO suscrito;

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

    public UserSecurityDTO getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(UserSecurityDTO suscriptor) {
        this.suscriptor = suscriptor;
    }

    public UserSecurityDTO getSuscrito() {
        return suscrito;
    }

    public void setSuscrito(UserSecurityDTO suscrito) {
        this.suscrito = suscrito;
    }
}
