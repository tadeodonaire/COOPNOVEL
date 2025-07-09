package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Proyectos;

import java.util.List;

public interface IProyectosService {

    public List<Proyectos> list();
    public void insert(Proyectos p);
    public Proyectos searchbyId(int id);
    public void update(Proyectos p);
    public void delete(int id);

    public List<String[]>findbuscarporNombreProyecto(String nombre);
}
