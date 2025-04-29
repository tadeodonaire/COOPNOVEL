package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Correcciones_IA;

import java.util.List;

@Repository
public interface ICorrecciones_IARepository extends JpaRepository<Correcciones_IA, Integer> {

    @Query(value = "SELECT \n" +
            "    cap.cap_titulo,\n" +
            "    n.nov_titulo\n" +
            "FROM \n" +
            "    capitulos cap\n" +
            "JOIN \n" +
            "    novelas n ON cap.id_novela = n.id_novela\n" +
            "WHERE \n" +
            "    c.id_correccionia IS NULL;", nativeQuery = true)
    List<String[]> getCapsinCor();

    @Query(value = "SELECT \n" +
            "    c.id_capitulo,\n" +
            "    c.cor_correcionia\n" +
            "FROM \n" +
            "    correcciones c;", nativeQuery = true)
    List<String[]> getCorrPorIDCap(int idCapitulo);
}
