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
}
