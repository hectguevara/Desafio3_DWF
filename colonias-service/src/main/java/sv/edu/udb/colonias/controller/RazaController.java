package sv.edu.udb.colonias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.colonias.model.Raza;
import sv.edu.udb.colonias.repository.RazaRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RazaController {

    private final RazaRepository razaRepository;

    public RazaController(RazaRepository razaRepository) {
        this.razaRepository = razaRepository;
    }

    @GetMapping("/razas")
    public List<Raza> listarRazas() {
        return razaRepository.findAll();
    }

    @GetMapping("/raza/{id}")
    public ResponseEntity<Raza> obtenerRazaPorId(@PathVariable Long id) {
        return razaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/raza")
    public Raza crearRaza(@RequestBody Raza raza) {
        return razaRepository.save(raza);
    }

    @PutMapping("/raza/{id}")
    public ResponseEntity<Raza> actualizarRaza(@PathVariable Long id, @RequestBody Raza nuevaRaza) {
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
        return razaRepository.findById(id)
                .map(raza -> {
                    razaRepository.delete(raza);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
