package pe.edu.upc.coopnovel.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.CapitulosDTO;
import pe.edu.upc.coopnovel.dtos.NumeroCapituloPorNovelaDTO;
import pe.edu.upc.coopnovel.entities.Capitulos;
import pe.edu.upc.coopnovel.serviceinterfaces.ICapitulosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/capitulos")
public class CapitulosController {

    @Autowired
    private ICapitulosService cS;


    @GetMapping
    @PreAuthorize("hasAnyAuthority('AUTOR', 'ADMINISTRADOR','COLABORADOR','LECTOR')")
    public List<CapitulosDTO> listar() {

        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CapitulosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('AUTOR', 'ADMINISTRADOR')")
    public void insertar(@RequestBody CapitulosDTO dto) {
        ModelMapper m = new ModelMapper();
        Capitulos c = m.map(dto, Capitulos.class);
        cS.inserCapitulo(c);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('AUTOR', 'ADMINISTRADOR','COLABORADOR')")
    public void modificar(@RequestBody CapitulosDTO dto) {
        ModelMapper m = new ModelMapper();
        Capitulos c = m.map(dto, Capitulos.class);
        cS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('AUTOR', 'ADMINISTRADOR','COLABORADOR')")
    public CapitulosDTO listarId(@PathVariable ("id") Integer id){
        ModelMapper m=new ModelMapper();
        CapitulosDTO dto=m.map(cS.listId(id), CapitulosDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('AUTOR', 'ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }


    @GetMapping("/cantidad-capitulo")
    @PreAuthorize("hasAnyAuthority('AUTOR', 'ADMINISTRADOR','COLABORADOR','LECTOR')")
    public List<NumeroCapituloPorNovelaDTO> cantidadCapitulo(@RequestParam String titulo) {
        List<NumeroCapituloPorNovelaDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = cS.findCapituloByName(titulo);
        for (String[] columna : filaLista) {
            NumeroCapituloPorNovelaDTO dto = new NumeroCapituloPorNovelaDTO();
            dto.setNovTitulo(columna[0]);
            dto.setNovResumen(columna[1]);
            dto.setNovGenero(columna[2]);
            dto.setNovCantidadCapitulos(Integer.parseInt(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
