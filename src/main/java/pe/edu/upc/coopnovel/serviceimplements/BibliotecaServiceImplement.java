package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Biblioteca;
import pe.edu.upc.coopnovel.repositories.IBibliotecaRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IBibliotecaService;

import java.util.List;
@Service
public class BibliotecaServiceImplement implements IBibliotecaService {

    @Autowired
    private IBibliotecaRepository bibR;

    @Override
    public void insert(Biblioteca b) {
        bibR.save(b);
    }

    @Override
    public List<Biblioteca> list() {
        return bibR.findAll();
    }

    @Override
    public Biblioteca listById(int id) {
        return bibR.findById(id).orElse(new Biblioteca());
    }

    @Override
    public void update(Biblioteca b) {
        bibR.save(b);
    }

    @Override
    public void delete(int id) {
        bibR.deleteById(id);
    }
}