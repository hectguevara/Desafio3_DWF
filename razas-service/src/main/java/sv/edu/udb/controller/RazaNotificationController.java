package sv.edu.udb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.dto.ColonyNotificationDTO;
import sv.edu.udb.service.RazaService;

@RestController
@RequestMapping("/api/v1/razas/notify")
@CrossOrigin
public class RazaNotificationController {
    private static final Logger logger = LoggerFactory.getLogger(RazaNotificationController.class);
    
    private final RazaService razaService;

    public RazaNotificationController(RazaService razaService) {
        this.razaService = razaService;
    }

    @PostMapping("/nueva-colonia")
    public ResponseEntity<Void> nuevaColonia(@RequestBody ColonyNotificationDTO colonia) {
        logger.info("Recibida notificación de nueva colonia: {}", colonia.getNombre());
        razaService.procesarNuevaColonia(colonia);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cambio-poblacion")
    public ResponseEntity<Void> cambioPoblacion(@RequestBody ColonyNotificationDTO colonia) {
        logger.info("Recibida notificación de cambio de población en colonia: {}", colonia.getNombre());
        razaService.procesarCambioPoblacion(colonia);
        return ResponseEntity.ok().build();
    }
} 