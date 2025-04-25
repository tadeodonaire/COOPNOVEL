package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Reuniones;
import pe.edu.upc.coopnovel.repositories.IReunionesRepository;
import pe.edu.upc.coopnovel.serviceinterfaces.IReunionesService;

import java.util.List;

@Service
public class ReunionesServiceImplement implements IReunionesService {
    // Assuming you have a repository for Reuniones, you would inject it here

    @Autowired
    IReunionesRepository reuRepository;

    @Override
    public List<Reuniones> list() {
        return reuRepository.findAll();
    }

    @Override
    public void insert(Reuniones reunion) {
        reuRepository.save(reunion);
    }

    @Override
    public Reuniones listById(int id) {
        return reuRepository.findById(id).orElse(new Reuniones());
    }

    @Override
    public void update(Reuniones reunion) {
        reuRepository.save(reunion);
    }

    @Override
    public void delete(int id) {
        reuRepository.deleteById(id);
    }
}
