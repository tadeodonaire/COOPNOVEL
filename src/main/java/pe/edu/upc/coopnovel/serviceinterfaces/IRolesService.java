package pe.edu.upc.coopnovel.serviceinterfaces;

import pe.edu.upc.coopnovel.entities.Roles;
import java.util.List;

public interface IRolesService {
    public List<Roles> list();
    public void insertRoles (Roles roles);
    public Roles listId (int id);
    public void delete (int id);
    public void update (Roles roles);
}
