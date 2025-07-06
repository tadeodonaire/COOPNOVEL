package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {

    public Usuarios findOneByUsername(String username);

    @Query(value = "SELECT us_nombre, us_apellido, DATE_PART('year', AGE(CURRENT_DATE, us_fec_nacimiento)) AS edad\n" +
            "FROM usuarios;",nativeQuery = true)
    public List<String[]> ListAge();

    @Query(value = "SELECT \n" +
            "    TO_CHAR(s.sus_fecha_inicio, 'YYYY-MM') AS mes,\n" +
            "    COUNT(*) AS total_suscripciones\n" +
            "FROM suscripciones s\n" +
            "WHERE s.id_suscriptor = :id\n" +
            "  AND s.sus_fecha_inicio BETWEEN '2022-01-01' AND '2024-12-31'\n" +
            "GROUP BY TO_CHAR(s.sus_fecha_inicio, 'YYYY-MM')\n" +
            "ORDER BY mes;\n",nativeQuery = true)
    public List<String[]> ListSuscripcionPorMes(@Param("id") int id);


    @Query(value = "SELECT \n" +
            "        nb.id_novela_biblioteca,\n" +
            "        b.id_biblioteca, b.bib_nombre,\n" +
            "        n.id_novela, n.nov_titulo, n.nov_resumen, n.nov_genero,\n" +
            "        p.id_proyecto, p.proy_titulo, p.proy_descripcion,\n" +
            "        u.id_usuario, u.us_nombre, u.us_apellido, u.username,\n" +
            "        c.id_capitulo, c.cap_titulo, c.cap_contenido\n" +
            "    FROM novelas_bibliotecas nb\n" +
            "    JOIN biblioteca b ON nb.id_biblioteca = b.id_biblioteca\n" +
            "    JOIN novelas n ON nb.id_novela = n.id_novela\n" +
            "    JOIN proyectos p ON n.id_proyectos = p.id_proyecto\n" +
            "    JOIN usuarios u ON p.id_usuarios = u.id_usuario\n" +
            "    LEFT JOIN capitulos c ON c.id_novela = n.id_novela\n" +
            "    WHERE u.id_usuario = :usuarioId\n" +
            "    ORDER BY b.id_biblioteca, n.id_novela, c.id_capitulo", nativeQuery = true)
    List<String[]> obtenerBibliotecaCompleta(@Param("usuarioId") int usuarioId);

}
