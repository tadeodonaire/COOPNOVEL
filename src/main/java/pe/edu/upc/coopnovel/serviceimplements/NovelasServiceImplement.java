package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.repositories.INovelasRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasService;

import java.util.List;

@Service
public class NovelasServiceImplement implements INovelasService {

    @Autowired
    private INovelasRepository nR;


    @Override
    public List<Novelas> list() { return nR.findAll(); }

    @Override
    public void insert(Novelas n) { nR.save(n); }

    @Override
    public Novelas searchbyid(int id) {
        return nR.findById(id).orElse(new Novelas());
    }

    @Override
    public void update(Novelas n) { nR.save(n); }

    @Override
    public void delete(int id) { nR.deleteById(id); }

    @Override
    public List<String[]> findbuscarporNombre(String nombre) {
        return nR.findbucarporNombre(nombre);
    }

    @Override
    public List<String[]> ObtenerNovelarFULL() {
        return nR.ObtenerNovelarFULL();
    }

}
