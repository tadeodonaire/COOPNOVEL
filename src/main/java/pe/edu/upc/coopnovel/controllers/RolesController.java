package pe.edu.upc.coopnovel.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.RolesDTO;
import pe.edu.upc.coopnovel.entities.Role;
import pe.edu.upc.coopnovel.serviceinterfaces.IRolesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rS;

    @GetMapping
    public List<RolesDTO> listar(){

        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert (@RequestBody RolesDTO dtorol){
        ModelMapper m=new ModelMapper();
        Role r = m.map(dtorol, Role.class);
        rS.insertRoles(r);
    }

    @GetMapping("/{id}")
    public RolesDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        RolesDTO dto=m.map(rS.listId(id), RolesDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Integer id){
        rS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RolesDTO dto){
        ModelMapper m=new ModelMapper();
        Role r=m.map(dto, Role.class);
        rS.update(r);
    }

}
