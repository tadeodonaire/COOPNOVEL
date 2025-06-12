package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.CantidadComentariosxCapituloDTO;
import pe.edu.upc.coopnovel.dtos.ComentariosDTO;
import pe.edu.upc.coopnovel.dtos.TopThreeComentatorsDTO;
import pe.edu.upc.coopnovel.entities.Comentarios;
import pe.edu.upc.coopnovel.serviceinterfaces.IComentariosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    IComentariosService comS;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN','COLABORADOR','LECTOR')")
    public List<ComentariosDTO> list() {
        return comS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ComentariosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN','COLABORADOR','LECTOR')")
    public void insert(@RequestBody ComentariosDTO comDto) {
        ModelMapper m = new ModelMapper();
        Comentarios com = m.map(comDto, Comentarios.class);
        comS.insert(com);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN','COLABORADOR','LECTOR')")
    public ComentariosDTO listById(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ComentariosDTO comDto = m.map(comS.listById(id), ComentariosDTO.class);
        return comDto;
    }

    @PutMapping
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN')")
    public void update(@RequestBody ComentariosDTO comDto ) {
        ModelMapper m = new ModelMapper();
        Comentarios com = m.map(comDto, Comentarios.class);
        comS.update(com);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN')")
    public void delete(@PathVariable("id") int id) {
        comS.delete(id);
    }

    @GetMapping("/cantidad-comentarios")
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN')")
    public List<CantidadComentariosxCapituloDTO> listCantidadComentarios() {
        List<CantidadComentariosxCapituloDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = comS.findCantidadComentarios();
        for (String[] columna : filaLista) {
            CantidadComentariosxCapituloDTO dto = new CantidadComentariosxCapituloDTO();
            dto.setUsNombre(columna[0]);
            dto.setCapTitulo(columna[1]);
            dto.setComFecha(LocalDate.parse(columna[2]));
            dto.setCantidadComentarios(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/top-three-comentators")
    //@PreAuthorize("hasAnyAuthority('AUTOR', 'ADMIN')")
    public List<TopThreeComentatorsDTO> listTopTenComentators() {
        List<TopThreeComentatorsDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = comS.getTopThreeComentators();
        for (String[] columna : filaLista) {
            TopThreeComentatorsDTO dto = new TopThreeComentatorsDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setUsNombre(columna[1]);
            dto.setUsApellido(columna[2]);
            dto.setTotalComentarios(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
