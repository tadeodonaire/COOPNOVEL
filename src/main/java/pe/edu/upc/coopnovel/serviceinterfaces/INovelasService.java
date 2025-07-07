package pe.edu.upc.coopnovel.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.coopnovel.entities.Capitulos;
import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

public interface INovelasService {

    public List<Novelas> list();
    public void insert(Novelas n);
    public Novelas searchbyid (int id);
    public void update(Novelas n);
    public void delete(int id);
    public List<String[]> findbuscarporNombre(String nombre);
    public List<String[]>ObtenerNovelarFULL();
    public List<Capitulos> listarPorNovela(Long idNovela);
    List<String[]> listarComentariosPorNovela(int idNovela);

}
