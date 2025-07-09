package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Suscripciones;

import java.util.List;

public interface ISuscripcionesService {
    public List <Suscripciones> list();
    public void insert(Suscripciones s);
    public Suscripciones listId(int id);
    public void update(Suscripciones s);
    public void delete(int id);
    public List<String[]>obtenerSuscripcionesxId(int idUsuario);
    public List<String[]> getUsersSubscribedMore();
    public List<String[]> getUsersSubscribed();
    public void eliminarPorUsuarios(int idSuscriptor, int idSuscrito);
    List<Integer> obtenerIdsSuscripcionesDeUsuario(int idSuscriptor);


}
