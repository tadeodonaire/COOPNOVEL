package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.CorreccionesIA;

import java.util.List;

@Repository
public interface ICorreccionesIARepository extends JpaRepository<CorreccionesIA, Integer> {

//    @Query(value = "SELECT \n" +
//            "    cap.cap_titulo,\n" +
//            "    n.nov_titulo\n" +
//            "FROM \n" +
//            "    capitulos cap\n" +
//            "JOIN \n" +
//            "    novelas n ON cap.id_novela = n.id_novela\n" +
//            "WHERE \n" +
//            "    c.id_correccionia IS NULL;", nativeQuery = true)

    @Query(value = "SELECT cap.id_capitulo,cap.cap_titulo, n.nov_titulo\n" +
            "FROM capitulos cap\n" +
            "JOIN novelas n ON cap.id_novela = n.id_novela\n" +
            "LEFT JOIN correcciones c ON cap.id_capitulo = c.id_capitulo\n" +
            "WHERE c.id_correccionia IS NULL;\n",nativeQuery = true)
    List<String[]> getCapsinCor();

    @Query(value = " SELECT c.id_capitulo,c.cor_correcionia FROM correcciones c\n" +
            " where c.id_capitulo = : idCapitulo", nativeQuery = true)
    List<String[]> getCorrPorIDCap(@Param("idCapitulo") int idCapitulo);

    //sugerencia
    //List<CorreccionesIA> findByCapitulosIdCapitulo(int idCapitulo);
}
