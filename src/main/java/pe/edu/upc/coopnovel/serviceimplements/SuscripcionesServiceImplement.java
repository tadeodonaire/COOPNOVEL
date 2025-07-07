package pe.edu.upc.coopnovel.serviceimplements;

import jakarta.transaction.Transactional;
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

    @Override
    public List<String[]> obtenerSuscripcionesxId(int idUsuario) {
        return sR.findByUsuarioId(idUsuario);
    }

    @Override
    public List<String[]> getUsersSubscribedMore() {
        return sR.getUsersSubscribedMore();
    }

    @Override
    public List<String[]> getUsersSubscribed() {
        return sR.getUsersSubscribed();
    }

    @Transactional
    @Override
    public void eliminarPorUsuarios(int idSuscriptor, int idSuscrito) {
        sR.deleteBySuscriptorAndSuscrito(idSuscriptor, idSuscrito);
    }

    @Override
    public List<Integer> obtenerIdsSuscripcionesDeUsuario(int idSuscriptor) {
        return sR.findSuscripcionesIdsBySuscriptor(idSuscriptor);
    }


}
