package pe.edu.upc.coopnovel.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.CapitulosDTO;
import pe.edu.upc.coopnovel.dtos.UsuariosDTO;
import pe.edu.upc.coopnovel.entities.Capitulos;
import pe.edu.upc.coopnovel.serviceinterfaces.ICapitulosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/capitulos")
public class CapitulosController {
    @Autowired
    private ICapitulosService cS;

    @GetMapping
    public List<CapitulosDTO> listar() {

        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CapitulosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CapitulosDTO dto) {
        ModelMapper m = new ModelMapper();
        Capitulos c = m.map(dto, Capitulos.class);
        cS.inserCapitulo(c);
    }

    @PutMapping
    public void modificar(@RequestBody CapitulosDTO dto) {
        ModelMapper m = new ModelMapper();
        Capitulos c = m.map(dto, Capitulos.class);
        cS.update(c);
    }
    @GetMapping("/{id}")
    public CapitulosDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        CapitulosDTO dto=m.map(cS.listId(id), CapitulosDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }

}
