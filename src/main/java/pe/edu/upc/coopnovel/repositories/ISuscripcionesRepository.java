package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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
            "JOIN Usuarios u ON s.id_usuario = u.id_usuario\n" +
            "GROUP BY u.id_usuario, u.us_nombre, u.us_apellido\n" +
            "HAVING COUNT(s.id_suscripcion) > 1\n" +
            "ORDER BY totalSuscripciones DESC;\n",nativeQuery=true)
    public List<String[]> getUsersSubscribedMore();
}
