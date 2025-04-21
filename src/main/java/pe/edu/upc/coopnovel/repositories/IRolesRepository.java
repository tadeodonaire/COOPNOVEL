package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Roles;


@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer> {
}
