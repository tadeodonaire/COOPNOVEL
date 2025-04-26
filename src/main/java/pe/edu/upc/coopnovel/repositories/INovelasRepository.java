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
}
