package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.*;
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
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
    public void delete(@PathVariable ("id") Integer id){
        uS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
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

    @GetMapping("/CantidadSuscripcion")
    public List<QuerySuscripcionDTO> ListSuscripcionPorMes(@RequestParam("a") int id){
        List<QuerySuscripcionDTO> dtosub = new ArrayList<>();
        List<String[]> filaLista = uS.ListSuscripcionPorMes(id);
        for (String[] columna : filaLista) {
            QuerySuscripcionDTO dto = new QuerySuscripcionDTO();

            dto.setMes(columna[0]);
            dto.setTotalSuscripcion(Integer.parseInt(columna[1]));
            dtosub.add(dto);
        }
        return dtosub;
    }
    @GetMapping("/BibliotecaFull")
    public List<BibliotecaFULLDTO> getBibliotecaFull(@RequestParam("a") int id) {
        List<BibliotecaFULLDTO> resultado = new ArrayList<>();
        List<String[]> filas = uS.obtenerBibliotecaCompleta(id); // Llama a tu servicio

        for (String[] columna :filas ) {
            BibliotecaFULLDTO b = new BibliotecaFULLDTO();
            // Índices correctos según tu SELECT en el @Query
            b.setIdBiblioteca(columna[0] != null ? Integer.parseInt(columna[0]) : null);
            b.setBibNombre(columna[1]);

            b.setIdNovela(columna[2] != null ? Integer.parseInt(columna[2]) : null);
            b.setNovTitulo(columna[3]);
            b.setNovResumen(columna[4]);
            b.setNovGenero(columna[5]);

            b.setIdCapitulo(columna[6] != null ? Integer.parseInt(columna[6]) : null);
            b.setCapTitulo(columna[7] != null ? columna[7] : "");
            b.setCapContenido(columna[8] != null ? columna[8] : "");

            b.setIdUsuario(columna[9] != null ? Integer.parseInt(columna[9]) : null);
            b.setUsNombre(columna[10]);
            b.setUsApellido(columna[11]);
            b.setUsername(columna[12]);
            resultado.add(b);
        }
        return resultado;
    }

}
