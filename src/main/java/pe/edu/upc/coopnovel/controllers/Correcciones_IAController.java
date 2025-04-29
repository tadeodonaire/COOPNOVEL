package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.CapSinCorrIADTO;
import pe.edu.upc.coopnovel.dtos.CorrPorIDCapDTO;
import pe.edu.upc.coopnovel.dtos.Correcciones_IADTO;
import pe.edu.upc.coopnovel.entities.Correcciones_IA;
import pe.edu.upc.coopnovel.serviceimplements.CapitulosServiceImplement;
import pe.edu.upc.coopnovel.serviceimplements.Correcciones_IAServiceImplements;
import pe.edu.upc.coopnovel.serviceinterfaces.ICorrecciones_IAService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Correcciones")
public class Correcciones_IAController {
    @Autowired
    private ICorrecciones_IAService corS;
    @Autowired
    private CapitulosServiceImplement capitulosServiceImplement;

    @GetMapping
    public List<Correcciones_IADTO> list() {
        return corS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,Correcciones_IADTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody Correcciones_IADTO dto){
        ModelMapper m = new ModelMapper();
        Correcciones_IA c = m.map(dto, Correcciones_IA.class);
        corS.insertCorreccion(c);
    }

    @PutMapping
    public void update(@RequestBody Correcciones_IADTO dto){
        ModelMapper m = new ModelMapper();
        Correcciones_IA c = m.map(dto, Correcciones_IA.class);
        corS.update(c);
    }

    @GetMapping("/{id}")
    public Correcciones_IADTO listById(@PathVariable ("id") Integer id){
        ModelMapper m = new ModelMapper();
        Correcciones_IADTO dto=m.map(corS.listId(id), Correcciones_IADTO.class);
        return dto;
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
