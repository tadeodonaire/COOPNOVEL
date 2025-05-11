package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.CorreccionesIA;

import java.util.List;

@Repository
public interface ICorreccionesIARepository extends JpaRepository<CorreccionesIA, Integer> {

    @Query(value = "SELECT cap.cap_titulo\n" +
            "FROM capitulos cap\n" +
            "LEFT JOIN correcciones c ON cap.id_capitulo = c.id_capitulo\n" +
            "WHERE c.id_correccionia IS NULL;", nativeQuery = true)
    List<String[]> getCapsinCor();

    @Query(value = "SELECT \n" +
            "    c.id_capitulo,\n" +
            "    c.cor_correcionia\n" +
            "FROM \n" +
            "    correcciones c \n" +
            "WHERE \n" +
            "    c.id_capitulo = :idCapitulo", nativeQuery = true)
    List<String[]> getCorrPorIDCap(@Param("idCapitulo") int idCapitulo);
}
