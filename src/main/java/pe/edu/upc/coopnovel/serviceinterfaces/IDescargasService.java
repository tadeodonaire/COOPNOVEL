package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Descargas;

import java.util.List;

public interface IDescargasService {

    public List<Descargas> list();
    public void insert(Descargas d);
    public void update(Descargas d);
    public void delete(int id);
    public List<Descargas> search(String n);
}
