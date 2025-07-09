package pe.edu.upc.coopnovel.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> list();
    public void insertUser (Usuarios usuarios);
    public Usuarios listId (int id);
    public void delete (int id);
    public void update (Usuarios usuarios);
    public List<String[]> ListAge();
    public List<String[]> ListSuscripcionPorMes(int id);
    List<String[]> obtenerBibliotecaCompleta(int usuarioId);
}
