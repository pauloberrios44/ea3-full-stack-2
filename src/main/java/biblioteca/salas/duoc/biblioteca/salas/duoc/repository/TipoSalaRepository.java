package biblioteca.salas.duoc.biblioteca.salas.duoc.repository;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSalaRepository extends JpaRepository<TipoSala, Integer> {
}
