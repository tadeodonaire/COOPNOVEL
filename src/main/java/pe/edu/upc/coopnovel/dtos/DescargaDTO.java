package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Usuarios;

import java.time.LocalDate;

public class DescargaDTO {

    private int idDescarga;

    private LocalDate hisFecha;

    private Usuarios user;

    public int getIdDescarga() {
        return idDescarga;
    }

    public void setIdDescarga(int idDescarga) {
        this.idDescarga = idDescarga;
    }

    public LocalDate getHisFecha() {
        return hisFecha;
    }

    public void setHisFecha(LocalDate hisFecha) {
        this.hisFecha = hisFecha;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
}
