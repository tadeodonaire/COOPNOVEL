package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.DescargasDTO;
import pe.edu.upc.coopnovel.entities.Descargas;
import pe.edu.upc.coopnovel.serviceinterfaces.IDescargasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/descargas")
public class DescargasController {

    @Autowired
    private IDescargasService dS;

    @GetMapping
    public List<DescargasDTO> listar() {

        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescargasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DescargasDTO dto) {
        ModelMapper m = new ModelMapper();
        Descargas d = m.map(dto, Descargas.class);
        dS.insert(d);
    }

    @PutMapping
    public void modificar(@RequestBody DescargasDTO dto) {
        ModelMapper m = new ModelMapper();
        Descargas d = m.map(dto, Descargas.class);
        dS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }

    @GetMapping("/nombres")
    public List<DescargasDTO> buscarPorNombre(@RequestParam String nombre) {
        return dS.search(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, DescargasDTO.class);
        }).collect(Collectors.toList());
    }
}
