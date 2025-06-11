package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carrera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {

    @Id
    @Column(length = 100)
    private String codigo;

    @Column(length = 100)
    private String nombre;
}
