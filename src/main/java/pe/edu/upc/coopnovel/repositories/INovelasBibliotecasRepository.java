package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.NovelasBibiotecas;
@Repository
public interface INovelasBibliotecasRepository extends JpaRepository <NovelasBibiotecas, Integer> {
}
