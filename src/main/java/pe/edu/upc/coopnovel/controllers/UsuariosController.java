package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.EdadUsuarioDTO;
import pe.edu.upc.coopnovel.dtos.EngagementPorUsuarioDTO;
import pe.edu.upc.coopnovel.dtos.PromedioCapituloxUsuarioDTO;
import pe.edu.upc.coopnovel.dtos.UsuariosDTO;
import pe.edu.upc.coopnovel.entities.Usuarios;
import pe.edu.upc.coopnovel.serviceinterfaces.IUsuariosService;

import java.util.ArrayList;
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
    public void insert (@RequestBody UsuariosDTO dtouser){
        ModelMapper m=new ModelMapper();
        Usuarios u = m.map(dtouser, Usuarios.class);
        uS.insertUser(u);
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

    @GetMapping("/promedio-capitulos")
    public PromedioCapituloxUsuarioDTO listarPromedioCapitulos() {
        Double promedio = uS.averagePerChapter();
        PromedioCapituloxUsuarioDTO dto = new PromedioCapituloxUsuarioDTO();
        dto.setPromedioCapitulos(promedio != null ? promedio : 0.0);
        return dto;
    }

    public List<EngagementPorUsuarioDTO> listarEngagement() {
        List<EngagementPorUsuarioDTO> dtoEngagement = new ArrayList<>();
        List<Object[]> filaLista = uS.engagementPerUser();
        for (Object[] columna : filaLista){
            EngagementPorUsuarioDTO dto = new EngagementPorUsuarioDTO();
            dto.setNombreUsuario(columna[0].toString());
            dto.setTotalCapitulos(Integer.parseInt(columna[1].toString()));
            dto.setTotalDescargas(Integer.parseInt(columna[2].toString()));
            dto.setTotalComentarios(Integer.parseInt(columna[3].toString()));
            dtoEngagement.add(dto);
        }
        return dtoEngagement;
    }
}
