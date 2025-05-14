package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Role;
import pe.edu.upc.coopnovel.repositories.IRolesRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IRolesService;

import java.util.List;

@Service
public class RolesServiceImplement implements IRolesService {

    @Autowired
    private IRolesRepository rR;

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void insertRoles(Role role) {
        rR.save(role);
    }

    @Override
    public Role listId(Long id) {
        return rR. findById(id).orElse(new Role());
    }

    @Override
    public void delete(Long id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Role role) {
        rR.save(role);
    }
}
