package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Biblioteca;

import java.util.List;

public interface IBibliotecaService {
    public void insert(Biblioteca b);
    public List<Biblioteca> list();
    public Biblioteca listById(int id);
    public void update(Biblioteca b);
    public void delete(int id);
    public List<String[]> buscarBibliotecasPorNombre(String nombre);
    public List<String[]> listarBibliotecasConTotalCapitulos();
}
