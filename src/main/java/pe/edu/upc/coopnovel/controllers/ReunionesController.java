package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.ReunionesDTO;
import pe.edu.upc.coopnovel.entities.Reuniones;
import pe.edu.upc.coopnovel.serviceinterfaces.IReunionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reuniones")
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
public class ReunionesController {
    @Autowired
    IReunionesService reuService;

    @GetMapping()
    public List<ReunionesDTO> list() {
        return reuService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReunionesDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReunionesDTO listById(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ReunionesDTO reunionesDTO = m.map(reuService.listById(id), ReunionesDTO.class);
        return reunionesDTO;
    }

    @PostMapping()
    public void insert(@RequestBody ReunionesDTO reuDto) {
        ModelMapper m = new ModelMapper();
        Reuniones reuniones = m.map(reuDto, Reuniones.class);
        reuService.insert(reuniones);
    }

    @PutMapping()
    public void update(@RequestBody ReunionesDTO reuDto) {
        ModelMapper m = new ModelMapper();
        Reuniones reuniones = m.map(reuDto, Reuniones.class);
        reuService.update(reuniones);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','AUTOR')")
    public void delete(@PathVariable("id") int id) {
        reuService.delete(id);
    }
}
