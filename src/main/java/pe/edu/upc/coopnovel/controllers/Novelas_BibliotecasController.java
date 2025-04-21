package pe.edu.upc.coopnovel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.coopnovel.entities.Novelas_Bibliotecas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelas_BibliotecasService;

import java.util.List;

@RestController
@RequestMapping("/novelas_bibliotecas")
public class Novelas_BibliotecasController {
    private INovelas_BibliotecasService nBL;

    
}
