package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Descarga;

import java.util.List;

public interface IDescargaService {

    public List<Descarga> list();
    public void insert(Descarga d);
    public void update(Descarga d);
    public void delete(int id);
    public List<Descarga> search(String n);
}
