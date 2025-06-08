package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.NovelasBibliotecas;
import pe.edu.upc.coopnovel.repositories.INovelasBibliotecasRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasBibliotecasService;

import java.util.List;


@Service
public class NovelasBibliotecasServiceImplement implements INovelasBibliotecasService {

    @Autowired
    private INovelasBibliotecasRepository nbR;

    @Override
    public List<NovelasBibliotecas> list() {
        return nbR.findAll();
    }

    @Override
    public void insert(NovelasBibliotecas nb) {
        nbR.save(nb);
    }

    @Override
    public NovelasBibliotecas searchbyid(int id) {
        return nbR.findById(id).orElse(new NovelasBibliotecas());
    }

    @Override
    public void update(NovelasBibliotecas nb) {
        nbR.save(nb);
    }

    @Override
    public void delete(int id) {
        nbR.deleteById(id);
    }
}
