package pe.edu.upc.coopnovel.dtos;

public class QuerySuscripcionDTO {
    private String Mes;
    private int TotalSuscripcion;

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }

    public int getTotalSuscripcion() {
        return TotalSuscripcion;
    }

    public void setTotalSuscripcion(int totalSuscripcion) {
        TotalSuscripcion = totalSuscripcion;
    }
}
