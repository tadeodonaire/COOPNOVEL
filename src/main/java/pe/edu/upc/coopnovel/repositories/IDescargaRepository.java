package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Descarga;

import java.util.List;

@Repository
public interface IDescargaRepository extends JpaRepository<Descarga, Integer> {
    @Query("select d from Descarga d join d.user u where u.usNombre like %:nombre%")
    public List<Descarga> buscar(@Param("nombre") String nombre);   

}
