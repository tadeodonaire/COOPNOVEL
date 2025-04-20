package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Proyectos;

import java.util.List;

public interface IProyectosService {

    public List<Proyectos> list();
    public void insert(Proyectos p);
    public void update(Proyectos p);
    public void delete(int id);
    public List<Proyectos> search(String n);
}
