package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Suscripciones;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

@Repository
public interface ISuscripcionesRepository extends JpaRepository<Suscripciones, Integer> {

    @Query(value = "SELECT s.id_usuario, s.id_suscripcion, s.sus_fecha_inicio \n" +
            "FROM suscripciones s \n" +
            "WHERE s.id_usuario = :idUsuario;", nativeQuery = true)
    List<String[]> findByUsuarioId(@Param("idUsuario") int idUsuario);

}
