package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Descarga;
import pe.edu.upc.coopnovel.repositories.IDescargaRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IDescargaService;

import java.util.List;

@Service
public class DescargaServiceImplement implements IDescargaService {

    @Autowired
    private IDescargaRepository dR;

    @Override
    public List<Descarga> list() { return dR.findAll(); }

    @Override
    public void insert(Descarga s) { dR.save(s); }

    @Override
    public void update(Descarga s) { dR.save(s); }

    @Override
    public void delete(int id) { dR.deleteById(id); }

    @Override
    public List<Descarga> search(String n) {
        return dR.buscar(n);
    }

}
