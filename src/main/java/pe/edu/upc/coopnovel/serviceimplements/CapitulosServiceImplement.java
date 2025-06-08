package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Capitulos;
import pe.edu.upc.coopnovel.repositories.ICapitulosRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.ICapitulosService;

import java.util.List;

@Service
public class CapitulosServiceImplement implements ICapitulosService {

    @Autowired
    private ICapitulosRepository cR;

    @Override
    public List<Capitulos> list() {
        return cR.findAll();
    }

    @Override
    public void inserCapitulo(Capitulos capitulos) {
        cR.save(capitulos);
    }

    @Override
    public Capitulos listId(int id) {
        return cR.findById(id).orElse(new Capitulos());
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Capitulos capitulos) {
        cR.save(capitulos);
    }

    @Override
    public List<String[]> findCapituloByName(String titulo) {
        return cR.findCapituloByName(titulo);
    }


    @Override
    public List<String[]> quantityCapitulosbyUsuario() {
        return cR.quantityCapitulosbyUsuario();
    }


}
