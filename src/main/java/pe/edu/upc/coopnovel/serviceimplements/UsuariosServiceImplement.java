package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Usuarios;
import pe.edu.upc.coopnovel.repositories.IUsuariosRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IUsuariosService;

import java.util.List;
@Service
public class UsuariosServiceImplement implements IUsuariosService {
    @Autowired
    private IUsuariosRepository uR;

    @Override
    public List<Usuarios> list() {
        return uR.findAll();
    }

    @Override
    public void insertar (Usuarios usuarios) {
        uR.save(usuarios);
    }

    @Override
    public Usuarios listId(int id) {
        return uR. findById(id).orElse(new Usuarios());
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public void update(Usuarios usuarios) {
        uR.save(usuarios);
    }
}
