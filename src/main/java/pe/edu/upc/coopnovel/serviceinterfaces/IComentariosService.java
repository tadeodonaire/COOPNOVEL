package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.dtos.ComentariosDTO;
import pe.edu.upc.coopnovel.entities.Comentarios;

import java.util.List;

public interface IComentariosService {
    public List<Comentarios> list();
    public Comentarios insert(Comentarios comentario);
    public Comentarios listById(int id);
    public void update(Comentarios comentario);
    public void delete(int id);
    public List<String[]> findCantidadComentarios();
    public List<String[]> getTopThreeComentators();
    List<ComentariosDTO> findByCapituloIdCapituloOrderByComFechaDesc(Integer idCapitulo);
}
