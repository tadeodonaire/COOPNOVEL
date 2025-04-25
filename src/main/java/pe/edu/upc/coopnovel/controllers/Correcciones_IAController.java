package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.Correcciones_IADTO;
import pe.edu.upc.coopnovel.entities.Correcciones_IA;
import pe.edu.upc.coopnovel.serviceinterfaces.ICorrecciones_IAService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Correcciones")
public class Correcciones_IAController {
    @Autowired
    private ICorrecciones_IAService corS;

    @GetMapping
    public List<Correcciones_IADTO> list() {
        return corS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,Correcciones_IADTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody Correcciones_IADTO dto){
        ModelMapper m = new ModelMapper();
        Correcciones_IA c = m.map(dto, Correcciones_IA.class);
        corS.insertCorreccion(c);
    }

    @PutMapping
    public void update(@RequestBody Correcciones_IADTO dto){
        ModelMapper m = new ModelMapper();
        Correcciones_IA c = m.map(dto, Correcciones_IA.class);
        corS.update(c);
    }

    @GetMapping("/{id}")
    public Correcciones_IADTO listById(@PathVariable ("id") Integer id){
        ModelMapper m = new ModelMapper();
        Correcciones_IADTO dto=m.map(corS.listId(id), Correcciones_IADTO.class);
        return dto;
    }
}
