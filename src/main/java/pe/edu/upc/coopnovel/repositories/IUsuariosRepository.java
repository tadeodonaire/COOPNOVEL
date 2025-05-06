package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
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
            "    ROUND(AVG(sub.capitulos_publicados), 2) AS promedio_capitulos_por_usuario_activo\n" +
            "FROM (\n" +
            "    SELECT \n" +
            "        u.id_usuario,\n" +
            "        COUNT(c.id_capitulo) AS capitulos_publicados\n" +
            "    FROM usuarios u\n" +
            "    JOIN proyectos p ON p.id_usuarios = u.id_usuario\n" +
            "    JOIN novelas n ON n.id_proyectos = p.id_proyecto\n" +
            "    JOIN capitulos c ON c.id_novela = n.id_novela\n" +
            "    WHERE u.us_enable = TRUE\n" +
            "    GROUP BY u.id_usuario\n" +
            ") sub;", nativeQuery = true)
    public Double averagePerChapter();

    @Query(value = "SELECT \n" +
            "        u.id_usuario,\n" +
            "        u.us_nombre,\n" +
            "        COUNT(DISTINCT c.id_capitulo) AS total_capitulos_publicados,\n" +
            "        COUNT(DISTINCT cm.id_comentario) AS total_comentarios,\n" +
            "        COUNT(DISTINCT d.id_descarga) AS total_descargas\n" +
            "    FROM usuarios u\n" +
            "    JOIN suscripciones s ON s.id_usuario = u.id_usuario\n" +
            "    LEFT JOIN proyectos p ON p.id_usuarios = u.id_usuario\n" +
            "    LEFT JOIN novelas n ON n.id_proyectos = p.id_proyecto\n" +
            "    LEFT JOIN capitulos c ON c.id_novela = n.id_novela\n" +
            "    LEFT JOIN comentarios cm ON cm.id_usuario = u.id_usuario\n" +
            "    LEFT JOIN descarga d ON d.usuario_id = u.id_usuario\n" +
            "    GROUP BY u.id_usuario, u.us_nombre\n" +
            "    ORDER BY total_capitulos_publicados DESC", nativeQuery = true)
    public List<Object[]> engagementPerUser();
}
