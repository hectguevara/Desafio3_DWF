package sv.edu.udb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sv.edu.udb.model.Raza;
import sv.edu.udb.repository.RazaRepository;
import sv.edu.udb.dto.ColonyNotificationDTO;

@Service
public class RazaService {
    private static final Logger logger = LoggerFactory.getLogger(RazaService.class);
    
    private final RazaRepository razaRepository;

    public RazaService(RazaRepository razaRepository) {
        this.razaRepository = razaRepository;
    }

    public void procesarNuevaColonia(ColonyNotificationDTO colonia) {
        logger.info("Procesando nueva colonia para raza ID: {}", colonia.getRazaId());
        Raza raza = razaRepository.findById(colonia.getRazaId())
                .orElse(null);
        
        if (raza != null) {
            // Actualizar población total
            raza.setPoblacionTotal(raza.getPoblacionTotal() + colonia.getPoblacion());
            razaRepository.save(raza);
            logger.info("Actualizada población total de la raza {} a {}", 
                       raza.getNombre(), raza.getPoblacionTotal());
        } else {
            logger.warn("No se encontró la raza con ID: {}", colonia.getRazaId());
        }
    }

    public void procesarCambioPoblacion(ColonyNotificationDTO colonia) {
        logger.info("Procesando cambio de población para raza ID: {}", colonia.getRazaId());
        Raza raza = razaRepository.findById(colonia.getRazaId())
                .orElse(null);
        
        if (raza != null) {
            // Aquí podrías implementar una lógica más compleja para actualizar la población
            // Por ahora solo registramos el evento
            logger.info("Cambio de población registrado para la raza {}: {} habitantes", 
                       raza.getNombre(), colonia.getPoblacion());
        } else {
            logger.warn("No se encontró la raza con ID: {}", colonia.getRazaId());
        }
    }
} 