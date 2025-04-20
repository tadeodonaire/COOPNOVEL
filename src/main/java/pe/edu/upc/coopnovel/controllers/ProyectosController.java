package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.ProyectosDTO;
import pe.edu.upc.coopnovel.entities.Proyectos;
import pe.edu.upc.coopnovel.serviceinterfaces.IProyectosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyectos")
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
    public void insertar(@RequestBody ProyectosDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyectos p = m.map(dto, Proyectos.class);
        pS.insert(p);
    }

    @PutMapping
    public void modificar(@RequestBody ProyectosDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyectos p = m.map(dto, Proyectos.class);
        pS.update(p);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }

    @GetMapping("/nombres")
    public List<ProyectosDTO> buscarPorNombre(@RequestParam String nombre) {
        return pS.search(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ProyectosDTO.class);
        }).collect(Collectors.toList());
    }
}
