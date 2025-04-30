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
    private IBibliotecaRepository bR;

    @Override
    public void insert(Biblioteca b) {
        bR.save(b);
    }

    @Override
    public List<Biblioteca> list() {
        return bR.findAll();
    }

    @Override
    public Biblioteca listById(int id) {
        return bR.findById(id).orElse(null);
    }

    @Override
    public void update(Biblioteca b) {
        bR.save(b);
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public List<String[]> buscarBibliotecasPorNombre(String nombre) {
        return bR.buscarBibliotecasPorNombre(nombre);
    }

    @Override
    public List<String[]> listarBibliotecasConTotalCapitulos() {
        return bR.listarBibliotecasConTotalCapitulos();
    }
}