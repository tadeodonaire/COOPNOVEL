package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.ComentariosDTO;
import pe.edu.upc.coopnovel.entities.Comentarios;
import pe.edu.upc.coopnovel.serviceinterfaces.IComentariosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    IComentariosService comS;

    @GetMapping
    public List<ComentariosDTO> list() {
        return comS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ComentariosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody ComentariosDTO comDto) {
        ModelMapper m = new ModelMapper();
        Comentarios com = m.map(comDto, Comentarios.class);
        comS.insert(com);
    }

    @GetMapping("/{id}")
    public ComentariosDTO listById(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ComentariosDTO comDto = m.map(comS.listById(id), ComentariosDTO.class);
        return comDto;
    }

    @PutMapping
    public void update(@RequestBody ComentariosDTO comDto ) {
        ModelMapper m = new ModelMapper();
        Comentarios com = m.map(comDto, Comentarios.class);
        comS.update(com);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        comS.delete(id);
    }

}
