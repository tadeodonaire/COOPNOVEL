package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.BibliotecaConCantidadCapitulosDTO;
import pe.edu.upc.coopnovel.dtos.BibliotecaDTO;
import pe.edu.upc.coopnovel.dtos.BibliotecaNombreDTO;
import pe.edu.upc.coopnovel.entities.Biblioteca;
import pe.edu.upc.coopnovel.serviceinterfaces.IBibliotecaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bibliotecas")
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
public class BibliotecaController {

    @Autowired
    private IBibliotecaService bibS;

    @GetMapping
    public List<BibliotecaDTO> list() {
        return bibS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BibliotecaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody BibliotecaDTO bibDto) {
        ModelMapper m = new ModelMapper();
        Biblioteca bib = m.map(bibDto, Biblioteca.class);
        bibS.insert(bib);
    }

    @GetMapping("/{id}")
    public BibliotecaDTO listById(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(bibS.listById(id), BibliotecaDTO.class);
    }

    @PutMapping
    public void update(@RequestBody BibliotecaDTO bibDto) {
        ModelMapper m = new ModelMapper();
        Biblioteca bib = m.map(bibDto, Biblioteca.class);
        bibS.update(bib);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        bibS.delete(id);
    }

    // ================= QUERIES ===================

    @GetMapping("/buscar-por-nombre")
    public List<BibliotecaNombreDTO> buscarBibliotecasPorNombre(@RequestParam String nombre) {
        List<BibliotecaNombreDTO> dtoLista = new ArrayList<>();
        List<String[]> lista = bibS.buscarBibliotecasPorNombre(nombre);
        for (String[] fila : lista) {
            BibliotecaNombreDTO dto = new BibliotecaNombreDTO();
            dto.setBibNombre(fila[0]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidad-capitulos")
    public List<BibliotecaConCantidadCapitulosDTO> cantidadCapitulosPorBiblioteca() {
        List<BibliotecaConCantidadCapitulosDTO> dtoLista = new ArrayList<>();
        List<String[]> lista = bibS.listarBibliotecasConTotalCapitulos();
        for (String[] fila : lista) {
            BibliotecaConCantidadCapitulosDTO dto = new BibliotecaConCantidadCapitulosDTO();
            dto.setBibNombre(fila[0]);
            dto.setCantidadCapitulos(Integer.parseInt(fila[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
