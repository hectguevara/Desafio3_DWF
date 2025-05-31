package sv.edu.udb.colonias.service;

import sv.edu.udb.colonias.model.Colonia;
import sv.edu.udb.colonias.repository.ColoniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ColoniaService {

    @Autowired
    private ColoniaRepository coloniaRepository;

    @Transactional(readOnly = true)
    public List<Colonia> obtenerTodasLasColonias() {
        return coloniaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Colonia> obtenerColoniaPorId(Long id) {
        return coloniaRepository.findById(id);
    }

    @Transactional
    public Colonia crearColonia(Colonia colonia) {
        return coloniaRepository.save(colonia);
    }

    @Transactional
    public Optional<Colonia> actualizarColonia(Long id, Colonia coloniaActualizada) {
        return coloniaRepository.findById(id)
            .map(coloniaExistente -> {
                coloniaExistente.setNombre(coloniaActualizada.getNombre());
                coloniaExistente.setCoordenadaX(coloniaActualizada.getCoordenadaX());
                coloniaExistente.setCoordenadaY(coloniaActualizada.getCoordenadaY());
                coloniaExistente.setCoordenadaZ(coloniaActualizada.getCoordenadaZ());
                coloniaExistente.setPoblacion(coloniaActualizada.getPoblacion());
                coloniaExistente.setRecursosNaturales(coloniaActualizada.getRecursosNaturales());
                coloniaExistente.setTecnologia(coloniaActualizada.getTecnologia());
                coloniaExistente.setAlianzasPoliticas(coloniaActualizada.getAlianzasPoliticas());
                coloniaExistente.setActiva(coloniaActualizada.getActiva());
                return coloniaRepository.save(coloniaExistente);
            });
    }

    @Transactional
    public boolean eliminarColonia(Long id) {
        return coloniaRepository.findById(id)
            .map(colonia -> {
                coloniaRepository.delete(colonia);
                return true;
            })
            .orElse(false);
    }
} 