package pe.edu.upc.coopnovel.serviceinterfaces;


import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.entities.NovelasBibliotecas;

import java.util.List;

public interface INovelasBibliotecasService {

    public List<NovelasBibliotecas> list();
    public void insert(NovelasBibliotecas nb);
    public NovelasBibliotecas searchbyid (int id);
    public void update(NovelasBibliotecas nb);
    public void delete(int id);
}

