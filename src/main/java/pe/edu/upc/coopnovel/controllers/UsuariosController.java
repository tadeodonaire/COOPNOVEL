package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.UsuariosDTO;
import pe.edu.upc.coopnovel.entities.Usuarios;
import pe.edu.upc.coopnovel.serviceinterfaces.IUsuariosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private IUsuariosService uS;

    @GetMapping
    public List <UsuariosDTO> listar(){

        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert (@RequestBody UsuariosDTO dto){
        ModelMapper m=new ModelMapper();
        Usuarios u=m.map(dto, Usuarios.class);
        uS.insertar(u);
    }

    @GetMapping("/{id}")
    public UsuariosDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsuariosDTO dto=m.map(uS.listId(id), UsuariosDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Integer id){
        uS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody UsuariosDTO dto){
        ModelMapper m=new ModelMapper();
        Usuarios u=m.map(dto, Usuarios.class);
        uS.update(u);
    }

}
