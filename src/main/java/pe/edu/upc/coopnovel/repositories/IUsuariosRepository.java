package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {

    //public Usuarios findOneByUsername(String username);

    @Query(value = "SELECT us_nombre, us_apellido, DATE_PART('year', AGE(CURRENT_DATE, us_fec_nacimiento)) AS edad\n" +
            "FROM usuarios;",nativeQuery = true)
    public List<String[]> ListAge();

}
