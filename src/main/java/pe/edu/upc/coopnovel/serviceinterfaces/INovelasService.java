package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

public interface INovelasService {

    public List<Novelas> list();
    public void insert(Novelas n);
    public Novelas searchbyid (int id);
    public void update(Novelas n);
    public void delete(int id);
    public List<String[]> findbuscarporNombre(String nombre);
    public List<String[]>ObtenerNovelarFULL();
}
