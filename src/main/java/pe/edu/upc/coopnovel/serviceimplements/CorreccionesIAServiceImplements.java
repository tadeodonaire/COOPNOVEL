package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.CorreccionesIA;
import pe.edu.upc.coopnovel.repositories.ICorreccionesIARepository;
import pe.edu.upc.coopnovel.serviceinterfaces.ICorreccionesIAService;

import java.util.List;

@Service
public class CorreccionesIAServiceImplements implements ICorreccionesIAService {

    @Autowired
    private ICorreccionesIARepository corR;

    @Override
    public List<CorreccionesIA> list() {
        return corR.findAll();
    }
    @Override
    public void insertCorreccion(CorreccionesIA correccion) {
        corR.save(correccion);
    }

    @Override
    public CorreccionesIA listId(int id) {
        return corR.findById(id).orElse(new CorreccionesIA());
    }
    @Override
    public void delete(int id) {corR.deleteById(id);}

    @Override
    public CorreccionesIA update(CorreccionesIA correcciones) {
        return corR.save(correcciones);
    }

    @Override
    public List<String[]> getCapsinCor() {
        return corR.getCapsinCor();
    }

    @Override
    public List<String[]> getCorrPorIDCap(int idCapitulo) {
        return corR.getCorrPorIDCap(idCapitulo);
    }


}
