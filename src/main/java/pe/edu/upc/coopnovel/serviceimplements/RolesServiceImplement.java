package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Roles;
import pe.edu.upc.coopnovel.repositories.IRolesRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IRolesService;

import java.util.List;

@Service
public class RolesServiceImplement implements IRolesService {

    @Autowired
    private IRolesRepository rR;

    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public void insertRoles(Roles roles) {
        rR.save(roles);
    }

    @Override
    public Roles listId(int id) {
        return rR. findById(id).orElse(new Roles());
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Roles roles) {
        rR.save(roles);
    }
}
