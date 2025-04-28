package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.coopnovel.dtos.NovelasBibliotecasDTO;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasBibliotecasService;

import java.util.List;

@RestController
@RequestMapping("/novelasbibliotecas")
public class NovelasBibliotecasController {
    @Autowired
    private INovelasBibliotecasService nb;

    public List <NovelasBibliotecasDTO> listar(){
        return nb.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NovelasBibliotecasDTO.class);
        }).collect(java.util.stream.Collectors.toList());
    }
}
