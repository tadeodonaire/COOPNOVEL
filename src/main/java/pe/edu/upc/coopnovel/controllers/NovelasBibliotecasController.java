package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.NovelasBibliotecasDTO;
import pe.edu.upc.coopnovel.entities.NovelasBibliotecas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasBibliotecasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/novelas-bibliotecas")
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
public class NovelasBibliotecasController {

    @Autowired
    private INovelasBibliotecasService nbS;

    @GetMapping
    public List<NovelasBibliotecasDTO> listar() {

        return nbS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NovelasBibliotecasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NovelasBibliotecasDTO nbdto) {
        ModelMapper m = new ModelMapper();
        NovelasBibliotecas nb = m.map(nbdto, NovelasBibliotecas.class);
        nbS.insert(nb);
    }

    @PutMapping
    public void modificar(@RequestBody NovelasBibliotecasDTO nbdto) {
        ModelMapper m = new ModelMapper();
        NovelasBibliotecas nb = m.map(nbdto, NovelasBibliotecas.class);
        nbS.update(nb);
    }

    @GetMapping("/{id}")
    public NovelasBibliotecasDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NovelasBibliotecasDTO dto = m.map(nbS.searchbyid(id), NovelasBibliotecasDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        nbS.delete(id);
    }

}
