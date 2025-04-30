package pe.edu.upc.coopnovel.serviceimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pe.edu.upc.coopnovel.dtos.NovelasBibliotecasDTO;
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

    @Override
    public void insert(NovelasBibiotecas n) {

    }

    @Override
    public void insert(NovelasBibliotecasDTO n) {
        ModelMapper m = new ModelMapper();
        NovelasBibiotecas nb = m.map(n,NovelasBibiotecas.class);
        nbb.save(nb);
    }

    @Override
    public void update(NovelasBibiotecas NovelasBibliotecas) {

    }

    @Override
    public void delete(int id) {

    }

    @PutMapping
    public void modificar( NovelasBibliotecasDTO dto) {
        ModelMapper m = new ModelMapper();
        NovelasBibiotecas nb = m.map(dto,NovelasBibiotecas.class);
        nb.update(nb);
    }

    @DeleteMapping("/{id}")
    public void eliminar (int id) {
        nbb.deleteById(id);
    }


}
