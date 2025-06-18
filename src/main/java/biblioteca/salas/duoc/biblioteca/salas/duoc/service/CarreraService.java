package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    // busqueda de una carrera por codigo
    public Carrera findByCodigo(String codigo) {
        return carreraRepository.findByCodigo(codigo);
    }
}
