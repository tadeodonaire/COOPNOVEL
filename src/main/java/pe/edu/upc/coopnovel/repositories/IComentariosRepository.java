package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Comentarios;

import java.util.List;

@Repository
public interface IComentariosRepository extends JpaRepository<Comentarios, Integer> {
    @Query(value = "select u.us_nombre, ca.cap_titulo, c.com_fecha, count(c.id_comentario) as cantidad_comentarios\n" +
            "from comentarios c\n" +
            "inner join usuarios u on c.id_usuario = u.id_usuario\n" +
            "inner join capitulos ca on c.id_capitulo = ca.id_capitulo\n" +
            "group by u.us_nombre, ca.cap_titulo, c.com_fecha\n" +
            "order by u.us_nombre, ca.cap_titulo, c.com_fecha\n", nativeQuery = true)
    public List<String[]> findCantidadComentarios();
}
