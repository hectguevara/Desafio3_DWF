package sv.edu.udb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Raza;
import sv.edu.udb.repository.RazaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class RazaController {

    private static final Logger logger = LoggerFactory.getLogger(RazaController.class);

    @Autowired
    private RazaRepository razaRepository;

    @GetMapping("/razas")
    public ResponseEntity<List<Raza>> listarRazas() {
        logger.info("GET /api/v1/razas - Listando todas las razas");
        List<Raza> razas = razaRepository.findAll();
        return ResponseEntity.ok(razas);
    }

    @GetMapping("/raza/{id}")
    public ResponseEntity<Raza> obtenerRazaPorId(@PathVariable Long id) {
        logger.info("GET /api/v1/raza/{} - Buscando raza por ID", id);
        return razaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/raza")
    public ResponseEntity<Raza> crearRaza(@RequestBody Raza raza) {
        logger.info("POST /api/v1/raza - Creando nueva raza: {}", raza);
        try {
            Raza nueva = razaRepository.save(raza);
            return ResponseEntity.ok(nueva);
        } catch (Exception e) {
            logger.error("Error al crear raza: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/raza/{id}")
    public ResponseEntity<Raza> actualizarRaza(@PathVariable Long id, @RequestBody Raza nuevaRaza) {
        logger.info("PUT /api/v1/raza/{} - Actualizando raza", id);
        return razaRepository.findById(id)
                .map(raza -> {
                    raza.setNombre(nuevaRaza.getNombre());
                    raza.setDescripcion(nuevaRaza.getDescripcion());
                    raza.setNivelTecnologico(nuevaRaza.getNivelTecnologico());
                    raza.setPoblacionTotal(nuevaRaza.getPoblacionTotal());
                    raza.setPlanetaOrigen(nuevaRaza.getPlanetaOrigen());
                    return ResponseEntity.ok(razaRepository.save(raza));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/raza/{id}")
    public ResponseEntity<Void> eliminarRaza(@PathVariable Long id) {
        logger.info("DELETE /api/v1/raza/{} - Eliminando raza", id);
        if (razaRepository.existsById(id)) {
            razaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 