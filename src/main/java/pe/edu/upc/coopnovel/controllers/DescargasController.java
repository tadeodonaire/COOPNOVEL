package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.DescargasDTO;
import pe.edu.upc.coopnovel.dtos.HistorialDescargasDTO;
import pe.edu.upc.coopnovel.dtos.NombreProyectosDTO;
import pe.edu.upc.coopnovel.entities.Descargas;
import pe.edu.upc.coopnovel.serviceinterfaces.IDescargasService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/descargas")
@PreAuthorize("hasAnyAuthority('ADMIN','COLABORADOR','USUARIO')")
public class DescargasController {

    @Autowired
    private IDescargasService dS;

    @GetMapping
    public List<DescargasDTO> listar() {

        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescargasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DescargasDTO dto) {
        ModelMapper m = new ModelMapper();
        Descargas d = m.map(dto, Descargas.class);
        dS.insert(d);
    }

    @PutMapping
    public void modificar(@RequestBody DescargasDTO dto) {
        ModelMapper m = new ModelMapper();
        Descargas d = m.map(dto, Descargas.class);
        dS.update(d);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }

    @GetMapping("/descargaxnombre")
    public List<HistorialDescargasDTO> buscarporNombreDescarga(@RequestParam String nombre) {
        List<HistorialDescargasDTO> dtoLista = new ArrayList<>();
        List<String[]> lista=dS.findbucarporNombreUsuarioDescarga(nombre);
        for (String[] columna : lista) {
            HistorialDescargasDTO dto = new HistorialDescargasDTO();
            dto.setHisFecha(LocalDate.parse(columna[0]));
            dto.setUsNombre(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
