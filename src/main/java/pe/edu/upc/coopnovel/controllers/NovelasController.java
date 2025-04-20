package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.NovelasDTO;
import pe.edu.upc.coopnovel.entities.Novelas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/novelas")
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

    @PutMapping
    public void modificar(@RequestBody NovelasDTO dto) {
        ModelMapper m = new ModelMapper();
        Novelas n = m.map(dto, Novelas.class);
        nS.update(n);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {nS.delete(id);
    }

    @GetMapping("/nombres")
    public List<NovelasDTO> buscarPorNombre(@RequestParam String nombre) {
        return nS.search(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NovelasDTO.class);
        }).collect(Collectors.toList());
    }
}
