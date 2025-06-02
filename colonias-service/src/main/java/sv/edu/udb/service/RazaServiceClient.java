package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sv.edu.udb.dto.RazaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

@Service
public class RazaServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(RazaServiceClient.class);
    
    private final RestTemplate restTemplate;
    private final String razasServiceUrl;

    public RazaServiceClient(RestTemplate restTemplate, 
                           @Value("${services.razas.url}") String razasServiceUrl) {
        this.restTemplate = restTemplate;
        this.razasServiceUrl = razasServiceUrl;
    }

    public RazaDTO getRazaById(Long id) {
        try {
            ResponseEntity<RazaDTO> response = restTemplate.getForEntity(
                razasServiceUrl + "/api/v1/raza/" + id,
                RazaDTO.class
            );
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error al obtener la raza con ID: " + id, e);
            return null;
        }
    }

    public RazaDTO[] getAllRazas() {
        try {
            ResponseEntity<RazaDTO[]> response = restTemplate.getForEntity(
                razasServiceUrl + "/api/v1/razas",
                RazaDTO[].class
            );
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error al obtener todas las razas", e);
            return new RazaDTO[0];
        }
    }
} 