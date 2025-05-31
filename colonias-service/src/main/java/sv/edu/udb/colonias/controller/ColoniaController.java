package sv.edu.udb.colonias.controller;

import sv.edu.udb.colonias.model.Colonia;
import sv.edu.udb.colonias.service.ColoniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ColoniaController {

    @Autowired
    private ColoniaService coloniaService;

    @GetMapping("/colonias")
    public ResponseEntity<List<Colonia>> obtenerTodasLasColonias() {
        return ResponseEntity.ok(coloniaService.obtenerTodasLasColonias());
    }

    @GetMapping("/colonia/{id}")
    public ResponseEntity<Colonia> obtenerColoniaPorId(@PathVariable Long id) {
        return coloniaService.obtenerColoniaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/colonia")
    public ResponseEntity<Colonia> crearColonia(@RequestBody Colonia colonia) {
        return ResponseEntity.ok(coloniaService.crearColonia(colonia));
    }

    @PutMapping("/colonia/{id}")
    public ResponseEntity<Colonia> actualizarColonia(@PathVariable Long id, @RequestBody Colonia colonia) {
        return coloniaService.actualizarColonia(id, colonia)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/colonia/{id}")
    public ResponseEntity<Void> eliminarColonia(@PathVariable Long id) {
        return coloniaService.eliminarColonia(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
} 