package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.NombreNovelaDTO;
import pe.edu.upc.coopnovel.dtos.NovelasDTO;
import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/novelas")
@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN','COLABORADOR','LECTOR')")
public class NovelasController {

    @Autowired
    private INovelasService nS;

    @GetMapping
    public List<NovelasDTO> listar() {

        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NovelasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NovelasDTO dto) {
        ModelMapper m = new ModelMapper();
        Novelas n = m.map(dto, Novelas.class);
        nS.insert(n);
    }

    @GetMapping("/{id}")
    public NovelasDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NovelasDTO dto = m.map(nS.searchbyid(id), NovelasDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody NovelasDTO dto) {
        ModelMapper m = new ModelMapper();
        Novelas n = m.map(dto, Novelas.class);
        nS.update(n);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {nS.delete(id);
    }

    @GetMapping("/nombresxbibliotecas")
    public List<NombreNovelaDTO> buscarporNombre(@RequestParam String nombre) {
        List<NombreNovelaDTO> dtoLista = new ArrayList<>();
        List<String[]> lista=nS.findbuscarporNombre(nombre);
        for (String[] columna : lista) {
            NombreNovelaDTO dto = new NombreNovelaDTO();
            dto.setNovTitulo(columna[0]);
            dto.setNovResumen(columna[1]);
            dto.setNovGenero(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
