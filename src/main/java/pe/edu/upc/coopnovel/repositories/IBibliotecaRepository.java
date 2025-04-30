package pe.edu.upc.coopnovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.coopnovel.entities.Biblioteca;

import java.util.List;

@Repository
public interface IBibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
    @Query(value = "SELECT b.bib_nombre, COUNT(nb.id_novela) AS total_novelas " +
            "FROM biblioteca b " +
            "LEFT JOIN novelas_bibliotecas nb ON b.id_biblioteca = nb.id_biblioteca " +
            "WHERE b.bib_nombre LIKE %:nombre% " +
            "GROUP BY b.bib_nombre", nativeQuery = true)
    public List<String[]> buscarBibliotecasPorNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT b.bib_nombre, COUNT(c.id_capitulo) AS total_capitulos " +
            "FROM biblioteca b " +
            "INNER JOIN novelas_bibliotecas nb ON b.id_biblioteca = nb.id_biblioteca " +
            "INNER JOIN novelas n ON nb.id_novela = n.id_novela " +
            "INNER JOIN capitulos c ON n.id_novela = c.id_novela " +
            "GROUP BY b.bib_nombre " +
            "ORDER BY b.bib_nombre", nativeQuery = true)
    public List<String[]> listarBibliotecasConTotalCapitulos();

}
