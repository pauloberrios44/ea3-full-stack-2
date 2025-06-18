package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrera") // <-- ruta base para mis servicios de carreras
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping("/")
    public ResponseEntity<?> listarCarreras() {
        return ResponseEntity.status(200).body(carreraService.findAll());
    }

//    @DeleteMapping("/borrar/{codigo}")
//    public ResponseEntity<?> borrarCarrera(@PathVariable String codigo) {
//
//    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarCarreraPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.status(200).body(carreraService.findByCodigo(codigo));
    }
}
