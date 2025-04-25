package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Novelas_Bibliotecas;
@Repository
public interface INovelas_BibliotecasRepository extends JpaRepository<Novelas_Bibliotecas, Integer> {

}
