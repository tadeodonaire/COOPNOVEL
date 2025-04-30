package pe.edu.upc.coopnovel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.coopnovel.dtos.NovelasBibliotecasDTO;
import pe.edu.upc.coopnovel.entities.NovelasBibiotecas;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelasBibliotecasService;

import java.util.List;

@RestController
@RequestMapping("/novelasbibliotecas")
public class NovelasBibliotecasController {

    private INovelasBibliotecasService nb;
    public NovelasBibliotecasController(INovelasBibliotecasService nb) {
        this.nb = nb;
    }

    public List <NovelasBibliotecasDTO> listar(){
        return nb.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NovelasBibliotecasDTO.class);
        }).collect(java.util.stream.Collectors.toList());
    }
    public void insertar(NovelasBibliotecasDTO dto){
        ModelMapper m = new ModelMapper();
        NovelasBibiotecas n = m.map(dto,NovelasBibiotecas.class);
        nb.insert(n);
    }
    public void modificar(NovelasBibliotecasDTO dto) {
        ModelMapper m = new ModelMapper();
        NovelasBibiotecas n = m.map(dto, NovelasBibiotecas.class);
        nb.update(n);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        nb.delete(id);
    }

}
