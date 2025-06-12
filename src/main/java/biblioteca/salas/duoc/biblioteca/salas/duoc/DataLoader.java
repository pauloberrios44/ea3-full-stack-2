package biblioteca.salas.duoc.biblioteca.salas.duoc;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // Creando tipos de sala
        for (int i = 0; i < 3; i++) {
            TipoSala tipoSala = new TipoSala();
            tipoSala.setNombre(faker.book().genre());
            tipoSalaRepository.save(tipoSala);
        }

        // Generar carreras
        for (int i = 0; i < 5; i++) {
            Carrera carrera = new Carrera();
            carrera.setCodigo(faker.code().asin());
            carrera.setNombre(faker.educator().course());
            carreraRepository.save(carrera);
        }
    }
}
