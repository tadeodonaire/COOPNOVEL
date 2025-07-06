package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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
}
