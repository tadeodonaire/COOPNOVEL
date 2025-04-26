package pe.edu.upc.coopnovel.dtos;

import java.time.LocalDate;

public class HistorialDescargasDTO {

    private LocalDate hisFecha;

    private String usNombre;

    public LocalDate getHisFecha() {
        return hisFecha;
    }

    public void setHisFecha(LocalDate hisFecha) {
        this.hisFecha = hisFecha;
    }

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }
}
