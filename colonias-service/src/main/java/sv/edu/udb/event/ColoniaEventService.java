package sv.edu.udb.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sv.edu.udb.model.Colony;
import sv.edu.udb.service.RazaServiceClient;

@Service
public class ColoniaEventService {
    private static final Logger logger = LoggerFactory.getLogger(ColoniaEventService.class);
    
    private final RestTemplate restTemplate;
    private final RazaServiceClient razaServiceClient;
    private final String razasServiceUrl;

    public ColoniaEventService(RestTemplate restTemplate, 
                             RazaServiceClient razaServiceClient,
                             @org.springframework.beans.factory.annotation.Value("${services.razas.url}") String razasServiceUrl) {
        this.restTemplate = restTemplate;
        this.razaServiceClient = razaServiceClient;
        this.razasServiceUrl = razasServiceUrl;
    }

    public void notificarNuevaColonia(Colony colony) {
        try {
            logger.info("Notificando nueva colonia al servicio de razas: {}", colony.getNombre());
            restTemplate.postForEntity(
                razasServiceUrl + "/api/v1/razas/notify/nueva-colonia",
                colony,
                Void.class
            );
        } catch (Exception e) {
            logger.error("Error al notificar nueva colonia: " + colony.getNombre(), e);
        }
    }

    public void notificarCambiosPoblacion(Colony colony) {
        try {
            logger.info("Notificando cambios en la población de la colonia: {}", colony.getNombre());
            restTemplate.postForEntity(
                razasServiceUrl + "/api/v1/razas/notify/cambio-poblacion",
                colony,
                Void.class
            );
        } catch (Exception e) {
            logger.error("Error al notificar cambios de población: " + colony.getNombre(), e);
        }
    }
} 