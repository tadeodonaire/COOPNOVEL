package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Reuniones;

import java.util.List;

public interface IReunionesService {
    public List<Reuniones> list();
    public void insert(Reuniones reunion);
    public Reuniones listById(int id);
    public void update(Reuniones reunion);
    public void delete(int id);
}
