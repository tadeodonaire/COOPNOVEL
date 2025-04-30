package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Comentarios;
import pe.edu.upc.coopnovel.repositories.IComentariosRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IComentariosService;

import java.util.List;

@Service
public class ComentariosServiceImplement implements IComentariosService {
    @Autowired
    IComentariosRepository comR;

    @Override
    public List<Comentarios> list() {
        return comR.findAll();
    }

    @Override
    public void insert(Comentarios comentario) {
        comR.save(comentario);
    }

    @Override
    public Comentarios listById(int id) {
        return comR.findById(id).orElse(new Comentarios());
    }

    @Override
    public void update(Comentarios comentario) {
        comR.save(comentario);
    }

    @Override
    public void delete(int id) {
        comR.deleteById(id);
    }

    @Override
    public List<String[]> findCantidadComentarios() { return comR.findCantidadComentarios(); }

    @Override
    public List<String[]> getTopTenComentators() {
        return comR.getTopTenComentators();
    }
}
