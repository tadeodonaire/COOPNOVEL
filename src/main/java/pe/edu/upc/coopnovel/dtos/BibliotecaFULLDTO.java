package pe.edu.upc.coopnovel.dtos;

public class BibliotecaFULLDTO {
    private Integer idBiblioteca;
    private String bibNombre;

    private Integer idNovela;
    private String novTitulo;
    private String novResumen;
    private String novGenero;

    private Integer idCapitulo;
    private String capTitulo;
    private String capContenido;

    private Integer idUsuario;
    private String usNombre;
    private String usApellido;
    private String username;

    public Integer getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Integer idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getBibNombre() {
        return bibNombre;
    }

    public void setBibNombre(String bibNombre) {
        this.bibNombre = bibNombre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsNombre() {
        return usNombre;
    }

    public void setUsNombre(String usNombre) {
        this.usNombre = usNombre;
    }

    public String getUsApellido() {
        return usApellido;
    }

    public void setUsApellido(String usApellido) {
        this.usApellido = usApellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdNovela() {
        return idNovela;
    }

    public void setIdNovela(Integer idNovela) {
        this.idNovela = idNovela;
    }

    public String getNovTitulo() {
        return novTitulo;
    }

    public void setNovTitulo(String novTitulo) {
        this.novTitulo = novTitulo;
    }

    public String getNovResumen() {
        return novResumen;
    }

    public void setNovResumen(String novResumen) {
        this.novResumen = novResumen;
    }

    public String getNovGenero() {
        return novGenero;
    }

    public void setNovGenero(String novGenero) {
        this.novGenero = novGenero;
    }

    public Integer getIdCapitulo() {
        return idCapitulo;
    }

    public void setIdCapitulo(Integer idCapitulo) {
        this.idCapitulo = idCapitulo;
    }

    public String getCapTitulo() {
        return capTitulo;
    }

    public void setCapTitulo(String capTitulo) {
        this.capTitulo = capTitulo;
    }

    public String getCapContenido() {
        return capContenido;
    }

    public void setCapContenido(String capContenido) {
        this.capContenido = capContenido;
    }
}


