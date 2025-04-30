package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.NovelasBibliotecas;

@Repository
public interface INovelasBibliotecasRepository extends JpaRepository <NovelasBibliotecas, Integer> {
}
