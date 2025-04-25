package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Descargas;

import java.util.List;

@Repository
public interface IDescargasRepository extends JpaRepository<Descargas, Integer> {
    @Query("select d from Descargas d join d.user u where u.usNombre like %:nombre%")
    public List<Descargas> buscar(@Param("nombre") String nombre);

}
