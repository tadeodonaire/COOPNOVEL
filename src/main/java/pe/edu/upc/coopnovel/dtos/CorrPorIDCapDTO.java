package pe.edu.upc.coopnovel.dtos;

public class CorrPorIDCapDTO {
    private int idCapitulo;
    private String capContenido;
    private String corCorreccionIA;

    public int getIdCapitulo() {return idCapitulo;}

    public void setIdCapitulo(int idCapitulo) {
        this.idCapitulo = idCapitulo;
    }

    public String getCorCorreccionIA() {
        return corCorreccionIA;
    }

    public void setCorCorreccionIA(String corCorreccionIA) {
        this.corCorreccionIA = corCorreccionIA;
    }

    public String getCapContenido() {
        return capContenido;
    }

    public void setCapContenido(String capContenido) {
        this.capContenido = capContenido;
    }
}
