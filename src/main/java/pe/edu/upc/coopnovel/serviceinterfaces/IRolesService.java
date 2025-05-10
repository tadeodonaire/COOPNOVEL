package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Role;
import java.util.List;

public interface IRolesService {
    public List<Role> list();
    public void insertRoles (Role role);
    public Role listId (Long id);
    public void delete (Long id);
    public void update (Role role);
}
