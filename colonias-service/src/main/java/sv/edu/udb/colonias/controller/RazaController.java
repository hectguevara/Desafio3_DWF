package sv.edu.udb.colonias.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.colonias.model.Raza;
import sv.edu.udb.colonias.repository.RazaRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/razas")
@CrossOrigin(origins = "*")
public class RazaController {

    private static final Logger logger = LoggerFactory.getLogger(RazaController.class);

    @Autowired
    private RazaRepository razaRepository;

    @GetMapping
    public ResponseEntity<List<Raza>> listarRazas() {
        logger.info("GET /v1/razas - Listando todas las razas");
        List<Raza> razas = razaRepository.findAll();
        return ResponseEntity.ok(razas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Raza> obtenerRazaPorId(@PathVariable Long id) {
        logger.info("GET /v1/razas/{} - Buscando raza por ID", id);
        return razaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Raza> crearRaza(@RequestBody Raza raza) {
        logger.info("POST /v1/razas - Creando nueva raza: {}", raza);
        try {
            Raza nueva = razaRepository.save(raza);
            return ResponseEntity.ok(nueva);
        } catch (Exception e) {
            logger.error("Error al crear raza: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Raza> actualizarRaza(@PathVariable Long id, @RequestBody Raza nuevaRaza) {
        logger.info("PUT /v1/razas/{} - Actualizando raza", id);
        return razaRepository.findById(id)
                .map(raza -> {
                    raza.setNombre(nuevaRaza.getNombre());
                    raza.setDescripcion(nuevaRaza.getDescripcion());
                    raza.setTecnologiasAvanzadas(nuevaRaza.getTecnologiasAvanzadas());
                    raza.setAliados(nuevaRaza.getAliados());
                    raza.setEnemigos(nuevaRaza.getEnemigos());
                    raza.setDatosPoliticos(nuevaRaza.getDatosPoliticos());
                    return ResponseEntity.ok(razaRepository.save(raza));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRaza(@PathVariable Long id) {
        logger.info("DELETE /v1/razas/{} - Eliminando raza", id);
        if (razaRepository.existsById(id)) {
            razaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
