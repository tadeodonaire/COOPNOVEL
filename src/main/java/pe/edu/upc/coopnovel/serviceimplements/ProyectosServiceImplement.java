package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Proyectos;
import pe.edu.upc.coopnovel.repositories.IProyectosRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IProyectosService;

import java.util.List;

@Service
public class ProyectosServiceImplement implements IProyectosService {

    @Autowired
    private IProyectosRepository pR;

    @Override
    public List<Proyectos> list() { return pR.findAll(); }

    @Override
    public void insert(Proyectos p) { pR.save(p); }

    @Override
    public Proyectos searchbyId(int id) {
        return pR.findById(id).orElse(new Proyectos());
    }

    @Override
    public void update(Proyectos p) { pR.save(p); }

    @Override
    public void delete(int id) { pR.deleteById(id); }

    @Override
    public List<String[]> findbuscarporNombreProyecto(String nombre) {
        return pR.findbucarporNombreProyecto(nombre);
    }
}
