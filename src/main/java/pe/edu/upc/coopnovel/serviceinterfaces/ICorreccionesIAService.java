package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.CorreccionesIA;

import java.util.List;

public interface ICorreccionesIAService {
    public List<CorreccionesIA> list();
    public void insertCorreccion (CorreccionesIA correccion);
    public CorreccionesIA listId (int id);
    public void delete(int id);
    public CorreccionesIA update (CorreccionesIA correcciones);
    public List<String[]> getCapsinCor();
    public List<String[]> getCorrPorIDCap(int idCapitulo);
}
