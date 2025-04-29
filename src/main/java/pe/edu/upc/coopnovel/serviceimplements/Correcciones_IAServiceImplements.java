package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Correcciones_IA;
import pe.edu.upc.coopnovel.repositories.ICorrecciones_IARepository;
import pe.edu.upc.coopnovel.serviceinterfaces.ICorrecciones_IAService;

import java.util.List;

@Service
public class Correcciones_IAServiceImplements implements ICorrecciones_IAService {

    @Autowired
    private ICorrecciones_IARepository corR;

    @Override
    public List<Correcciones_IA> list() {
        return corR.findAll();
    }
    @Override
    public void insertCorreccion(Correcciones_IA correccion) {
        corR.save(correccion);
    }

    @Override
    public Correcciones_IA listId(int id) {
        return corR.findById(id).orElse(new Correcciones_IA());
    }
    @Override
    public void delete(int id) {corR.deleteById(id);}

    @Override
    public Correcciones_IA update(Correcciones_IA correcciones) {
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
