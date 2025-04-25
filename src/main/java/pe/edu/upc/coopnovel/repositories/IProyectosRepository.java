package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.coopnovel.entities.Proyectos;

import java.util.List;

public interface IProyectosRepository extends JpaRepository<Proyectos, Integer> {
    @Query("select p from Proyectos p join p.usario u where u.usNombre like %:nombre%")
    public List<Proyectos> buscar(@Param("nombre") String nombre);
}
