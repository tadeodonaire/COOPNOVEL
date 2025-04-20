package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.DescargaDTO;
import pe.edu.upc.coopnovel.entities.Descarga;
import pe.edu.upc.coopnovel.serviceinterfaces.IDescargaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/descargas")
public class DescargaController {

    @Autowired
    private IDescargaService dS;

    @GetMapping
    public List<DescargaDTO> listar() {

        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescargaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DescargaDTO dto) {
        ModelMapper m = new ModelMapper();
        Descarga d = m.map(dto, Descarga.class);
        dS.insert(d);
    }

    @PutMapping
    public void modificar(@RequestBody DescargaDTO dto) {
        ModelMapper m = new ModelMapper();
        Descarga d = m.map(dto, Descarga.class);
        dS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }

    @GetMapping("/nombres")
    public List<DescargaDTO> buscarPorNombre(@RequestParam String nombre) {
        return dS.search(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DescargaDTO.class);
        }).collect(Collectors.toList());
    }
}
