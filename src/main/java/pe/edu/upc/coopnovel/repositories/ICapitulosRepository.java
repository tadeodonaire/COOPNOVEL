package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Capitulos;

import java.util.List;


@Repository
public interface ICapitulosRepository extends JpaRepository<Capitulos, Integer> {

    @Query(value = "SELECT n.nov_titulo, n.nov_resumen, n.nov_genero, COUNT(c.id_capitulo) AS total_capitulos " +
            "FROM novelas n INNER JOIN capitulos c ON n.id_novela = c.id_novela " +
            "WHERE n.nov_titulo LIKE %:titulo% " +
            "GROUP BY n.nov_titulo, n.nov_resumen, n.nov_genero", nativeQuery = true)
    List<String[]> findCapituloByName(@Param("titulo") String titulo);

    @Query(value = "select u.us_nombre, n.nov_titulo, count(c.id_capitulo) as cantidad_capitulos_descargados\n" +
            "from descarga d \n" +
            "inner join usuarios u on d.usuario_id = u.id_usuario\n" +
            "inner join capitulos c on d.id_descarga = c.id_capitulo\n" +
            "inner join novelas n on c.id_novela = n.id_novela\n" +
            "group by u.us_nombre,  n.nov_titulo\n" +
            "order by u.us_nombre, n.nov_titulo", nativeQuery = true)
    public List<String[]> quantityCapitulosbyUsuario();
}
