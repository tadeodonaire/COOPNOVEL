package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> list();
    public void insertar (Usuarios usuarios);
    public Usuarios listId (int id);
    public void delete (int id);
    public void update (Usuarios usuarios);
}
