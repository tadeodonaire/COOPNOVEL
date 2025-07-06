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
            b.setIdNovelaBiblioteca(Integer.parseInt(columna[0]));
            b.setIdBiblioteca(Integer.parseInt(columna[1]));
            b.setBibNombre(columna[2]);
            b.setIdNovela(Integer.parseInt(columna[3]));
            b.setNovTitulo(columna[4]);
            b.setNovResumen(columna[5]);
            b.setNovGenero(columna[6]);
            b.setIdProyecto(Integer.parseInt(columna[7]));
            b.setProyTitulo(columna[8]);
            b.setProyDescripcion(columna[9]);
            b.setIdUsuario(Integer.parseInt(columna[10]));
            b.setUsNombre(columna[11]);
            b.setUsApellido(columna[12]);
            b.setUsername(columna[13]);
            // Validación segura para columna[14] (idCapitulo)
            if (columna[14] != null && !columna[14].isBlank()) {
                b.setIdCapitulo(Integer.parseInt(columna[14]));
            } else {
                b.setIdCapitulo(null); // o 0 si prefieres
            }

            b.setCapTitulo(columna[15] != null ? columna[15] : "");
            b.setCapContenido(columna[16] != null ? columna[16] : "");
            resultado.add(b);
        }
        return resultado;
    }

}
