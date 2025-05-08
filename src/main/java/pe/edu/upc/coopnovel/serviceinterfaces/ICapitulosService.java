package pe.edu.upc.coopnovel.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Capitulos;

import java.util.List;

public interface ICapitulosService {
    public List<Capitulos> list();
    public void inserCapitulo (Capitulos capitulos);
    public Capitulos listId (int id);
    public void delete (int id);
    public void update (Capitulos capitulos);
    public List<String[]> findCapituloByName(String titulo);
    public List<String[]> quantityCapitulosbyUsuario();
}