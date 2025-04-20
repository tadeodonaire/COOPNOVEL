package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Capitulos;

import java.util.List;

public interface ICapitulosService {
    public List<Capitulos> list();
    public void inserCapitulo (Capitulos capitulos);
    public Capitulos listId (int id);
    public void delete (int id);
    public void update (Capitulos capitulos);
}
