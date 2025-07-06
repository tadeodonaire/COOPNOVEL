package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.CapSinCorrIADTO;
import pe.edu.upc.coopnovel.dtos.CorrPorIDCapDTO;
import pe.edu.upc.coopnovel.dtos.CorreccionesIADTO;
import pe.edu.upc.coopnovel.entities.CorreccionesIA;
import pe.edu.upc.coopnovel.serviceimplements.CapitulosServiceImplement;
import pe.edu.upc.coopnovel.serviceinterfaces.ICorreccionesIAService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Correcciones")
@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'LECTOR', 'COLABORADOR', 'AUTOR')")
public class CorreccionesIAController {
    @Autowired
    private ICorreccionesIAService corS;

    @GetMapping
    public List<CorreccionesIADTO> list() {
        return corS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, CorreccionesIADTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'COLABORADOR', 'AUTOR')")
    public void insert(@RequestBody CorreccionesIADTO dto){
        ModelMapper m = new ModelMapper();
        CorreccionesIA c = m.map(dto, CorreccionesIA.class);
        corS.insertCorreccion(c);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'COLABORADOR', 'AUTOR')")
    public void update(@RequestBody CorreccionesIADTO dto){
        ModelMapper m = new ModelMapper();
        CorreccionesIA c = m.map(dto, CorreccionesIA.class);
        corS.update(c);
    }

    @GetMapping("/{id}")
    public CorreccionesIADTO listById(@PathVariable ("id") Integer id){
        ModelMapper m = new ModelMapper();
        CorreccionesIADTO dto=m.map(corS.listId(id), CorreccionesIADTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") Integer id){
        corS.delete(id);
    }

    @GetMapping("/CapituloSinCorreccion")
    public List<CapSinCorrIADTO> listarCapitulosSinCorrecciones(){
        List<CapSinCorrIADTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = corS.getCapsinCor();

        for (String[] columna : filaLista) {
            CapSinCorrIADTO dto = new CapSinCorrIADTO();
            dto.setCapTitulo(columna[0]);
            dtoLista.add(dto);
        }

        return dtoLista;
    }

    @GetMapping("/CorreccionPorIDCapitulo")
    public List<CorrPorIDCapDTO> getCorrPorIDCap(@RequestParam int idCapitulo) {
        List<CorrPorIDCapDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = corS.getCorrPorIDCap(idCapitulo);
        for (String[] columna : filaLista) {
            CorrPorIDCapDTO dto = new CorrPorIDCapDTO();
            dto.setIdCapitulo(Integer.parseInt(columna[0]));
            dto.setCorCorreccionIA(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
