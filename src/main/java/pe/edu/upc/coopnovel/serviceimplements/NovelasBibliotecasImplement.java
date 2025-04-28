package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.NovelasBibiotecas;
import pe.edu.upc.coopnovel.repositories.INovelasBibliotecasRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasBibliotecasService;

import java.util.List;
@Service
public class NovelasBibliotecasImplement implements INovelasBibliotecasService {
   @Autowired
    private INovelasBibliotecasRepository nbb;

    @Override
    public List<NovelasBibiotecas> list() {
        return nbb.findAll();
    }
}
