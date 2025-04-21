package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Novelas_Bibliotecas;
import pe.edu.upc.coopnovel.repositories.INovelas_BibliotecasRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.INovelas_BibliotecasService;

import java.util.List;

@Service
public abstract class Novelas_BibliotecasServiceImplement implements INovelas_BibliotecasService {
    @Autowired
    private INovelas_BibliotecasRepository nBL;
    @Override
    public List<Novelas_Bibliotecas> list() {
        return nBL.findAll();
    }
}
