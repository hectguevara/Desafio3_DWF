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
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class RazaController {

    private static final Logger logger = LoggerFactory.getLogger(RazaController.class);

    @Autowired
    private RazaRepository razaRepository;

    @GetMapping("/razas")
    public ResponseEntity<List<Raza>> listarRazas() {
        logger.debug("Recibida solicitud para listar todas las razas");
        return ResponseEntity.ok(razaRepository.findAll());
    }

    @GetMapping("/raza/{id}")
    public ResponseEntity<Raza> obtenerRazaPorId(@PathVariable Long id) {
        logger.debug("Recibida solicitud para obtener raza con ID: {}", id);
        return razaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/raza")
    public ResponseEntity<Raza> crearRaza(@RequestBody Raza raza) {
        logger.debug("Recibida solicitud para crear nueva raza: {}", raza);
        Raza nueva = razaRepository.save(raza);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/raza/{id}")
    public ResponseEntity<Raza> actualizarRaza(@PathVariable Long id, @RequestBody Raza nuevaRaza) {
        logger.debug("Recibida solicitud para actualizar raza con ID: {}", id);
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

    @DeleteMapping("/raza/{id}")
    public ResponseEntity<Void> eliminarRaza(@PathVariable Long id) {
        logger.debug("Recibida solicitud para eliminar raza con ID: {}", id);
        if (razaRepository.existsById(id)) {
            razaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
