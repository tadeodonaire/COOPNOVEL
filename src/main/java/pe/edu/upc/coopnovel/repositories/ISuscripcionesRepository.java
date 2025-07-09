package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Suscripciones;

import java.util.List;

@Repository
public interface ISuscripcionesRepository extends JpaRepository<Suscripciones, Integer> {

    @Query(value = "SELECT s.id_usuario, s.id_suscripcion, s.sus_fecha_inicio \n" +
            "FROM suscripciones s \n" +
            "WHERE s.id_usuario = :idUsuario;", nativeQuery = true)
    List<String[]> findByUsuarioId(@Param("idUsuario") int idUsuario);

    @Query(value="SELECT u.id_usuario, u.us_nombre, u.us_apellido, COUNT(s.id_suscripcion) AS totalSuscripciones\n" +
            "FROM Suscripciones s\n" +
            "JOIN Usuarios u ON s.id_suscrito = u.id_usuario\n" +
            "GROUP BY u.id_usuario, u.us_nombre, u.us_apellido\n" +
            "HAVING COUNT(s.id_suscripcion) > 1\n" +
            "ORDER BY totalSuscripciones DESC;\n",nativeQuery=true)
    public List<String[]> getUsersSubscribedMore();

    @Query (value = "SELECT u.id_usuario, u.us_nombre, u.us_apellido,\n" +
            "COUNT(s.id_suscriptor) AS cantidad_suscriptores,\n" +
            "STRING_AGG(n.nov_titulo, ', ') AS novelas\n" +
            "FROM usuarios u LEFT JOIN \n" +
            "suscripciones s ON u.id_usuario = s.id_suscrito\n" +
            "LEFT JOIN proyectos p ON u.id_usuario = p.id_usuarios\n" +
            "LEFT JOIN novelas n ON p.id_proyecto = n.id_proyectos\n" +
            "WHERE u.role_id = 3\n" +
            "GROUP BY u.id_usuario, u.us_nombre, u.us_apellido\n" +
            "ORDER BY cantidad_suscriptores DESC",nativeQuery = true)
    public List<String[]> getUsersSubscribed();

    @Modifying
    @Query("DELETE FROM Suscripciones s WHERE s.suscriptor.idUsuario = :idSuscriptor AND s.suscrito.idUsuario = :idSuscrito")
    void deleteBySuscriptorAndSuscrito(@Param("idSuscriptor") int idSuscriptor, @Param("idSuscrito") int idSuscrito);

    @Query("SELECT s.suscrito.idUsuario FROM Suscripciones s WHERE s.suscriptor.idUsuario = :idSuscriptor")
    List<Integer> findSuscripcionesIdsBySuscriptor(@Param("idSuscriptor") int idSuscriptor);

}
