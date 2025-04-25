package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Novelas;

import java.util.List;

@Repository
public interface INovelasRepository extends JpaRepository <Novelas, Integer> {
    @Query("select n from Novelas n where n.novTitulo like %:nombre%")
    public List<Novelas> buscar(@Param("nombre") String nombre);
}
