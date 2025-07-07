package pe.edu.upc.coopnovel.dtos;
import java.time.LocalDate;

public class DescargasDTO {

    private int idDescarga;
    private LocalDate hisFecha;
    private UserSecurityDTO user;

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

    public UserSecurityDTO getUser() {
        return user;
    }

    public void setUser(UserSecurityDTO user) {
        this.user = user;
    }
}
