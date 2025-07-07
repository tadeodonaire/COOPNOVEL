package pe.edu.upc.coopnovel.dtos;

public class PromedioCapituloxUsuarioDTO {
    //Se crea un dto, aunque solo se devuelva un valor, para que aparezca promedioCapitulos: 123.123 en el JSON

    private Double promedioCapitulos;

    public Double getPromedioCapitulos() {
        return promedioCapitulos;
    }

    public void setPromedioCapitulos(Double promedioCapitulos) {
        this.promedioCapitulos = promedioCapitulos;
    }
}
