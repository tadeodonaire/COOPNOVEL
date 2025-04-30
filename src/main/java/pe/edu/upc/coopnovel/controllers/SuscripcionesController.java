package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.RepeatUsersDTO;
import pe.edu.upc.coopnovel.dtos.SuscripcionesDTO;
import pe.edu.upc.coopnovel.dtos.SuscripcionesxUsuarioDTO;
import pe.edu.upc.coopnovel.entities.Suscripciones;
import pe.edu.upc.coopnovel.serviceinterfaces.ISuscripcionesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionesController {

    @Autowired
    private ISuscripcionesService sS;

    @GetMapping
    public List<SuscripcionesDTO> listar(){

        return sS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, SuscripcionesDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insert(@RequestBody SuscripcionesDTO dto){
        ModelMapper m = new ModelMapper();
        Suscripciones s = m.map(dto, Suscripciones.class);
        sS.insert(s);
    }
    @GetMapping("/usuario/{idUsuario}")
    public List<SuscripcionesxUsuarioDTO> buscaridUsuario(@PathVariable("idUsuario") int idUsuario){
        List<SuscripcionesxUsuarioDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = sS.obtenerSuscripcionesxId(idUsuario);

        for (String[] columna : filaLista) {
            SuscripcionesxUsuarioDTO dto = new SuscripcionesxUsuarioDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setIdSuscripcion(Integer.parseInt(columna[1]));
            dto.setSusFechaInicio(LocalDate.parse(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/{id}")
    public SuscripcionesDTO buscarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        SuscripcionesDTO dto=m.map(sS.listId(id), SuscripcionesDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody SuscripcionesDTO dto){
        ModelMapper m = new ModelMapper();
        Suscripciones s = m.map(dto, Suscripciones.class);
        sS.update(s);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        sS.delete(id);
    }

    @GetMapping("/usuarios-suscritos")
    public List<RepeatUsersDTO> getUsersSubscribedMore() {
        List<RepeatUsersDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = sS.getUsersSubscribedMore();
        for (String[] columna : filaLista) {
            RepeatUsersDTO dto = new RepeatUsersDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setUsNombre(columna[1]);
            dto.setUsApellido(columna[2]);
            dto.setTotalSuscripciones(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
