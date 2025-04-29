package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Correcciones_IA;

import java.util.List;

public interface ICorrecciones_IAService {
    public List<Correcciones_IA> list();
    public void insertCorreccion (Correcciones_IA correccion);
    public Correcciones_IA listId (int id);
    public void delete(int id);
    public Correcciones_IA update (Correcciones_IA correcciones);
    public List<String[]> getCapsinCor();
    public List<String[]> getCorrPorIDCap(int idCapitulo);
}
