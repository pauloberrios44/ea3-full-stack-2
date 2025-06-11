package biblioteca.salas.duoc.biblioteca.salas.duoc.repository;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
