package pe.edu.upc.coopnovel.serviceimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.dtos.ComentariosDTO;
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
    public Comentarios insert(Comentarios comentario) {
        return comR.save(comentario); // importante: retorna el guardado
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
    public List<String[]> getTopThreeComentators() {
        return comR.getTopThreeComentators();
    }

    // ComentariosServiceImplement.java
    @Override
    public List<ComentariosDTO> findByCapituloIdCapituloOrderByComFechaDesc(Integer idCapitulo) {
        List<Comentarios> comentarios = comR.findByCapituloIdCapituloOrderByComFechaDesc(idCapitulo);
        ModelMapper m = new ModelMapper();
        return comentarios.stream()
                .map(c -> m.map(c, ComentariosDTO.class))
                .toList();
    }

}
