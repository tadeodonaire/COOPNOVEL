package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Descargas;
import pe.edu.upc.coopnovel.repositories.IDescargasRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IDescargasService;

import java.util.List;

@Service
public class DescargasServiceImplement implements IDescargasService {

    @Autowired
    private IDescargasRepository dR;

    @Override
    public List<Descargas> list() { return dR.findAll(); }

    @Override
    public void insert(Descargas d) { dR.save(d); }

    @Override
    public void update(Descargas d) { dR.save(d); }

    @Override
    public void delete(int id) { dR.deleteById(id); }

    @Override
    public List<String[]> findbucarporNombreUsuarioDescarga(String nombre) {
        return dR.findbucarporNombreUsuarioDescarga(nombre);
    }

}
