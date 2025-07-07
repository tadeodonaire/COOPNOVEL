package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Capitulos;
import pe.edu.upc.coopnovel.entities.Novelas;

import java.util.List;

@Repository
public interface INovelasRepository extends JpaRepository <Novelas, Integer> {

    @Query(value = "select n.nov_titulo, n.nov_resumen, n.nov_genero\n" +
            "from novelas n\n" +
            "where n.nov_titulo like %:nombre%", nativeQuery = true)
    public List<String[]>findbucarporNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT \n" +
            "    n.id_novela,\n" +
            "    n.nov_titulo,\n" +
            "    n.nov_resumen,\n" +
            "    n.nov_genero,\n" +
            "\n" +
            "    p.id_proyecto,\n" +
            "    p.proy_titulo,\n" +
            "    p.proy_descripcion,\n" +
            "\n" +
            "    u.id_usuario,\n" +
            "    u.us_nombre,\n" +
            "    u.us_apellido,\n" +
            "    u.username,\n" +
            "\n" +
            "    c.id_capitulo,\n" +
            "    c.cap_titulo,\n" +
            "    c.cap_contenido\n" +
            "\n" +
            "FROM novelas n\n" +
            "JOIN proyectos p ON n.id_proyectos = p.id_proyecto\n" +
            "JOIN usuarios u ON p.id_usuarios = u.id_usuario\n" +
            "LEFT JOIN capitulos c ON n.id_novela = c.id_novela\n" +
            "\n" +
            "ORDER BY n.id_novela, c.id_capitulo;", nativeQuery = true)
    public List<String[]>ObtenerNovelarFULL();

    @Query("SELECT c FROM Capitulos c WHERE c.novelas.idNovela = :idNovela ORDER BY c.idCapitulo")
    List<Capitulos> findByNovelaId(@Param("idNovela") Long idNovela);

    @Query(value = "SELECT com.id_comentario, com.com_contenido, com.com_fecha, " +
            "u.id_usuario, u.username, u.us_apellido, " +
            "c.id_capitulo, c.cap_titulo, " +
            "n.id_novela, n.nov_titulo " +
            "FROM comentarios com " +
            "JOIN usuarios u ON com.id_usuario = u.id_usuario " +
            "JOIN capitulos c ON com.id_capitulo = c.id_capitulo " +
            "JOIN novelas n ON c.id_novela = n.id_novela " +
            "WHERE n.id_novela = :idNovela " +
            "ORDER BY com.com_fecha DESC",
            nativeQuery = true)
    List<String[]> listarComentariosPorNovela(@Param("idNovela") int idNovela);

}
