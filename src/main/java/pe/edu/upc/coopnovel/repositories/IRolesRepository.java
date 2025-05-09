package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Role;


@Repository
public interface IRolesRepository extends JpaRepository<Role, Long> {
}
