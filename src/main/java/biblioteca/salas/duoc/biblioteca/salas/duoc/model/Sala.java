package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sala")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    private Integer capacidad;

    @Column(nullable = false)
    private Integer idInstituto;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoSala tipoSala;
}
