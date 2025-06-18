package biblioteca.salas.duoc.biblioteca.salas.duoc;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.EstudianteRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.TipoSalaRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TipoSalaRepository tipoSalaRepository;

    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void run(String... args) throws Exception {

        if (!crearTiposSalas(3)) {
            throw new Exception("No se puede crear tipo de salas");
        }

        if (!crearCarreras(3)) {
            throw new Exception("No se puede crear carreras");
        }

        if (!crearEstudiantes(3)) {
            throw new Exception("No se puede crear estudiantes");
        }
    }

    private boolean crearTiposSalas(int cantidadTiposSalas) {
        try {
            Faker faker = new Faker();
            Random random = new Random();

            // Creando tipos de sala
            for (int i = 0; i < cantidadTiposSalas; i++) {
                TipoSala tipoSala = new TipoSala();
                tipoSala.setNombre(faker.book().genre());
                tipoSalaRepository.save(tipoSala);
            }

            return true;
        } catch (Exception e) {
            return false;
        }


    }

    private boolean crearCarreras(int cantidadCarreras) {
        Faker faker = new Faker();

        // Generar carreras
        for (int i = 0; i < cantidadCarreras; i++) {
            Carrera carrera = new Carrera();
            carrera.setCodigo(faker.code().asin());
            carrera.setNombre(faker.educator().course());
            carreraRepository.save(carrera);
        }

        return true;
    }

    private boolean crearEstudiantes(int cantidadEstudiantes) {
        Faker faker = new Faker();
        Random random = new Random();

        List<Carrera> carreras = carreraRepository.findAll();

        // Generar estudiantes
        for (int i = 0; i < cantidadEstudiantes; i++) {
            Estudiante estudiante = new Estudiante();
            //  cadena.substring(0, 4);
            String numeroRun = faker.idNumber().valid();
            numeroRun = numeroRun.replace("-", "");
            numeroRun = numeroRun.substring(0,8);
            estudiante.setRun(numeroRun);
            estudiante.setNombres(faker.name().fullName());
            estudiante.setCorreo(faker.internet().emailAddress());
            estudiante.setJornada(faker.options().option("D", "N").charAt(0));
            estudiante.setTelefono(faker.number().numberBetween(100000000, 999999999));
            estudiante.setCarrera(carreras.get(random.nextInt(carreras.size())));
            estudianteRepository.save(estudiante);
        }

        return true;
    }
}
