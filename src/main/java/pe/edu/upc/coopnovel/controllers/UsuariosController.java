package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.EdadUsuarioDTO;
import pe.edu.upc.coopnovel.dtos.UserSecurityDTO;
import pe.edu.upc.coopnovel.dtos.UsuariosDTO;
import pe.edu.upc.coopnovel.entities.Usuarios;
import pe.edu.upc.coopnovel.serviceinterfaces.IUsuariosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN','COLABORADOR','LECTOR')")
public class UsuariosController {
    @Autowired
    private IUsuariosService uS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List <UserSecurityDTO> listar(){

        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UserSecurityDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert (@RequestBody UsuariosDTO dtouser){
        ModelMapper m=new ModelMapper();
        Usuarios u = m.map(dtouser, Usuarios.class);
        uS.insertUser(u);
    }

    @GetMapping("/{id}")
    public UserSecurityDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        UserSecurityDTO dto=m.map(uS.listId(id), UserSecurityDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable ("id") Integer id){
        uS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody UserSecurityDTO dto){
        ModelMapper m=new ModelMapper();
        Usuarios u=m.map(dto, Usuarios.class);
        uS.update(u);
    }

    @GetMapping("/edad")
    public List<EdadUsuarioDTO> listarEdad(){
        List<EdadUsuarioDTO> dtoEdad = new ArrayList<>();
        List<String[]> filaLista = uS.ListAge();
        for (String[] columna : filaLista) {
            EdadUsuarioDTO dto = new EdadUsuarioDTO();

            dto.setUsNombre(columna[0]);
            dto.setUsApellido(columna[1]);
            dto.setUsEdad((int) Double.parseDouble(columna[2]));
            dtoEdad.add(dto);
        }
        return dtoEdad;
    }

}
