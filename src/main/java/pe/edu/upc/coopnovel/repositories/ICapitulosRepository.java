package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Capitulos;


@Repository
public interface ICapitulosRepository extends JpaRepository<Capitulos, Integer> {
}
