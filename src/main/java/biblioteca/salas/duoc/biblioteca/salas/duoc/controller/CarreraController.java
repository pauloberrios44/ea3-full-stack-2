package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Carreras", description = "Operaciones de CRUD relacionadas con carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping("/carrera")
    @Operation(summary = "Obtener todas las carreras", description = "Obtiene una lista de todas las carreras registradas en la base de datos")
    public ResponseEntity<?> listarCarreras() {
        return ResponseEntity.status(200).body(carreraService.findAll());
    }
}
