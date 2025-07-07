package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.NombreProyectosDTO;
import pe.edu.upc.coopnovel.dtos.ProyectosDTO;
import pe.edu.upc.coopnovel.entities.Proyectos;
import pe.edu.upc.coopnovel.serviceinterfaces.IProyectosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyectos")
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
public class ProyectosController {

    @Autowired
    private IProyectosService pS;

    @GetMapping
    public List<ProyectosDTO> listar() {

        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProyectosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'COLABORADOR', 'AUTOR')")
    public void insertar(@RequestBody ProyectosDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyectos p = m.map(dto, Proyectos.class);
        pS.insert(p);
    }

    @GetMapping("/{id}")
    public ProyectosDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ProyectosDTO dto = m.map(pS.searchbyId(id), ProyectosDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'COLABORADOR', 'AUTOR')")
    public void modificar(@RequestBody ProyectosDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyectos p = m.map(dto, Proyectos.class);
        pS.update(p);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'COLABORADOR', 'AUTOR')")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }

    @GetMapping("/proyectosxnombre")
    public List<NombreProyectosDTO> buscarporNombreProyecto(@RequestParam String nombre) {
        List<NombreProyectosDTO> dtoLista = new ArrayList<>();
        List<String[]> lista=pS.findbuscarporNombreProyecto(nombre);
        for (String[] columna : lista) {
            NombreProyectosDTO dto = new NombreProyectosDTO();
            dto.setProyTitulo(columna[0]);
            dto.setProyDescripcion(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
