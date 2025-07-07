package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.CorreccionesIA;

import java.util.List;

@Repository
public interface ICorreccionesIARepository extends JpaRepository<CorreccionesIA, Integer> {

    @Query(value = "SELECT cap.id_capitulo, cap.cap_titulo " +
            "FROM capitulos cap " +
            "LEFT JOIN correcciones c ON cap.id_capitulo = c.id_capitulo " +
            "WHERE c.id_correccionia IS NULL", nativeQuery = true)
    List<String[]> getCapsinCor();

    @Query(value = "SELECT c.id_capitulo, cap.cap_contenido, c.cor_correcionia " +
            "FROM correcciones c " +
            "JOIN capitulos cap ON c.id_capitulo = cap.id_capitulo " +
            "WHERE c.id_capitulo = :idCapitulo", nativeQuery = true)
    List<String[]> getCorrPorIDCap(@Param("idCapitulo") int idCapitulo);
}
