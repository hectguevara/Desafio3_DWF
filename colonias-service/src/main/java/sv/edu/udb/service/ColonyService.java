package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.model.Colony;
import sv.edu.udb.repository.ColonyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ColonyService {
    
    @Autowired
    private ColonyRepository colonyRepository;
    
    public List<Colony> getAllColonies() {
        return colonyRepository.findAll();
    }
    
    public Optional<Colony> getColonyById(Long id) {
        return colonyRepository.findById(id);
    }
    
    public Colony createColony(Colony colony) {
        return colonyRepository.save(colony);
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