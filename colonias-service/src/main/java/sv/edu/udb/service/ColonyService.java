package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sv.edu.udb.model.Colony;
import sv.edu.udb.repository.ColonyRepository;
import sv.edu.udb.dto.RazaDTO;
import sv.edu.udb.event.ColoniaEventService;

import java.util.List;
import java.util.Optional;

@Service
public class ColonyService {
    
    @Autowired
    private ColonyRepository colonyRepository;
    
    @Autowired
    private RazaServiceClient razaServiceClient;
    
    @Autowired
    private ColoniaEventService coloniaEventService;
    
    public List<Colony> getAllColonies() {
        return colonyRepository.findAll();
    }
    
    public Optional<Colony> getColonyById(Long id) {
        return colonyRepository.findById(id);
    }
    
    public Colony createColony(Colony colony) {
        // Validar que la raza existe
        RazaDTO raza = razaServiceClient.getRazaById(colony.getRazaId());
        if (raza == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                "No se puede crear la colonia porque la raza con ID " + colony.getRazaId() + " no existe");
        }
        
        Colony savedColony = colonyRepository.save(colony);
        coloniaEventService.notificarNuevaColonia(savedColony);
        return savedColony;
    }
    
    public Colony updateColony(Long id, Colony colony) {
        if (colonyRepository.existsById(id)) {
            colony.setId(id);
            return colonyRepository.save(colony);
        }
        return null;
    }
    
    public void deleteColony(Long id) {
        colonyRepository.deleteById(id);
    }
} 