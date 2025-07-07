package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Capitulos;

public class CorreccionesIADTO {
    private int idCorreccionIA;
    private String corCorreccionIA;
    private CapitulosDTO capitulos;

    public int getIdCorreccionIA() {
        return idCorreccionIA;
    }

    public void setIdCorreccionIA(int idCorreccionIA) {
        this.idCorreccionIA = idCorreccionIA;
    }

    public String getCorCorreccionIA() {
        return corCorreccionIA;
    }

    public void setCorCorreccionIA(String corCorreccionIA) {
        this.corCorreccionIA = corCorreccionIA;
    }

    public CapitulosDTO getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(CapitulosDTO capitulos) {
        this.capitulos = capitulos;
    }
}
