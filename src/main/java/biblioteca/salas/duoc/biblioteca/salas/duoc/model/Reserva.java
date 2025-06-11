package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "codigo_sala", nullable = false)
    private Sala sala;

    @Column(nullable = false)
    private Date fechaSolicitada; // fecha_solicitada

    @Column(nullable = false)
    private Date horaSolicitada;

    private Date horaCierre;

    @Column(nullable = false)
    private Integer estado;


}
