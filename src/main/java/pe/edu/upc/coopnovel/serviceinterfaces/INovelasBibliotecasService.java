package pe.edu.upc.coopnovel.serviceinterfaces;


import pe.edu.upc.coopnovel.dtos.NovelasBibliotecasDTO;
import pe.edu.upc.coopnovel.entities.NovelasBibiotecas;

import java.util.List;

public interface INovelasBibliotecasService {

    public List<NovelasBibiotecas> list();
    void insert(NovelasBibiotecas n);
    void insert(NovelasBibliotecasDTO n);
    public void update (NovelasBibiotecas novelasBibiotecas);
    public void delete(int id);
}

