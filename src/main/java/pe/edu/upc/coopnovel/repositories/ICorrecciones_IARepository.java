package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Correcciones_IA;

@Repository
public interface ICorrecciones_IARepository extends JpaRepository<Correcciones_IA, Integer> {

}
