package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Biblioteca;

import java.util.List;

public interface IBibliotecaService {
    void insert(Biblioteca b);
    List<Biblioteca> list();
    Biblioteca listById(int id);
    void update(Biblioteca b);
    void delete(int id);
}
