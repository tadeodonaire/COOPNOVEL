package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.coopnovel.dtos.Novelas_BibliotecasDTO;
import pe.edu.upc.coopnovel.entities.Novelas_Bibliotecas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelas_BibliotecasService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/novelas_bibliotecas")
public class Novelas_BibliotecasController {
    private INovelas_BibliotecasService nBL;

    public List<Novelas_BibliotecasDTO > listar(){
        return nBL.list().stream().map((x) -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Novelas_BibliotecasDTO.class);
        }).collect(Collectors.toList());
    }

    
}
