package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.dtos.ComentariosDTO;
import pe.edu.upc.coopnovel.entities.Comentarios;

import java.util.List;

@Repository
public interface IComentariosRepository extends JpaRepository<Comentarios, Integer> {
    @Query(value = "select u.us_nombre, ca.cap_titulo,  count(c.id_comentario) as cantidad_comentarios\n" +
            "from comentarios c\n" +
            "inner join capitulos ca on ca.id_capitulo = c.id_capitulo\n" +
            "inner join usuarios u on u.id_usuario = c.id_usuario\n" +
            "group by u.us_nombre, ca.cap_titulo\n" +
            "order by u.us_nombre, ca.cap_titulo", nativeQuery = true)
    public List<String[]> findCantidadComentarios();
    @Query(value="SELECT u.id_usuario, u.us_nombre, u.us_apellido, COUNT(c.id_comentario) AS totalComentarios\n" +
            "FROM Comentarios c\n" +
            "JOIN Usuarios u ON c.id_usuario = u.id_usuario\n" +
            "GROUP BY u.id_usuario, u.us_nombre, u.us_apellido\n" +
            "ORDER BY totalComentarios DESC\n" +
            "LIMIT 3\n", nativeQuery = true)
    public List<String[]> getTopThreeComentators();

    List<Comentarios> findByCapituloIdCapituloOrderByComFechaDesc(Integer idCapitulo);
}
