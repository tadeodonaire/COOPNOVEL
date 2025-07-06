package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.NombreNovelaDTO;
import pe.edu.upc.coopnovel.dtos.NovelasDTO;
import pe.edu.upc.coopnovel.entities.NovelaFullDTO;
import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/novelas")
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
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
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'AUTOR')")
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
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'AUTOR')")
    public void modificar(@RequestBody NovelasDTO dto) {
        ModelMapper m = new ModelMapper();
        Novelas n = m.map(dto, Novelas.class);
        nS.update(n);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'AUTOR')")
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

    @GetMapping("/NovelasVer")
    public List<NovelaFullDTO> ObtenerNovelarFULL() {
        List<NovelaFullDTO> dtoLista = new ArrayList<>();
        List<String[]> lista=nS.ObtenerNovelarFULL();
        for (String[] columna : lista) {
            NovelaFullDTO dto = new NovelaFullDTO();

            dto.setIdNovela(Integer.parseInt(columna[0]));
            dto.setNovTitulo(columna[1]);
            dto.setNovResumen(columna[2]);
            dto.setNovGenero(columna[3]);

            dto.setIdProyecto(Integer.parseInt(columna[4]));
            dto.setProyTitulo(columna[5]);
            dto.setProyDescripcion(columna[6]);

            dto.setIdUsuario(Integer.parseInt(columna[7]));
            dto.setUsNombre(columna[8]);
            dto.setUsApellido(columna[9]);
            dto.setUsername(columna[10]);

            // Capítulo puede ser nulo (left join), validar
            if (columna[11] != null && !columna[11].isEmpty()) {
                dto.setIdCapitulo(Integer.parseInt(columna[11]));
                dto.setCapTitulo(columna[12]);
                dto.setCapContenido(columna[13]);
            }

            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
