package pe.edu.upc.coopnovel.dtos;

import pe.edu.upc.coopnovel.entities.Capitulos;

public class Correcciones_IADTO {
    private int idCorreccionIA;
    private String corCorreccionIA;
    private Capitulos capitulos;

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

    public Capitulos getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Capitulos capitulos) {
        this.capitulos = capitulos;
    }
}
