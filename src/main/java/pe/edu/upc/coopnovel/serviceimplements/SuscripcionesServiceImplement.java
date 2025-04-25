package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Suscripciones;
import pe.edu.upc.coopnovel.repositories.ISuscripcionesRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.ISuscripcionesService;

import java.util.List;

@Service
public class SuscripcionesServiceImplement implements ISuscripcionesService {

    @Autowired
    private ISuscripcionesRepository sR;

    @Override
    public List<Suscripciones> list() { return sR.findAll(); }

    @Override
    public void insert(Suscripciones s) { sR.save(s); }

    @Override
    public Suscripciones listId(int id) { return sR.findById(id).orElse(new Suscripciones()); }

    @Override
    public void update(Suscripciones s) { sR.save(s); }

    @Override
    public void delete(int id) { sR.deleteById(id); }
}
