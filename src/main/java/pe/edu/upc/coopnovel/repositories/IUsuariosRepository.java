package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Usuarios;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {

    public Usuarios findOneByUsername(String username);

    @Query(value = "SELECT us_nombre, us_apellido, DATE_PART('year', AGE(CURRENT_DATE, us_fec_nacimiento)) AS edad\n" +
            "FROM usuarios;",nativeQuery = true)
    public List<String[]> ListAge();

    @Query(value = "SELECT \n" +
            "    TO_CHAR(s.sus_fecha_inicio, 'YYYY-MM') AS mes,\n" +
            "    COUNT(*) AS total_suscripciones\n" +
            "FROM suscripciones s\n" +
            "WHERE s.id_suscriptor = :id\n" +
            "  AND s.sus_fecha_inicio BETWEEN '2022-01-01' AND '2024-12-31'\n" +
            "GROUP BY TO_CHAR(s.sus_fecha_inicio, 'YYYY-MM')\n" +
            "ORDER BY mes;\n",nativeQuery = true)
    public List<String[]> ListSuscripcionPorMes(@Param("id") int id);

}
