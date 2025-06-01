package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Colony;
import sv.edu.udb.service.ColonyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ColonyController {

    @Autowired
    private ColonyService colonyService;

    @GetMapping("/colonias")
    public List<Colony> getAllColonies() {
        return colonyService.getAllColonies();
    }

    @GetMapping("/colonia/{id}")
    public ResponseEntity<Colony> getColonyById(@PathVariable Long id) {
        return colonyService.getColonyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/colonia")
    public Colony createColony(@RequestBody Colony colony) {
        return colonyService.createColony(colony);
    }

    @PutMapping("/colonia/{id}")
    public ResponseEntity<Colony> updateColony(@PathVariable Long id, @RequestBody Colony colony) {
        Colony updatedColony = colonyService.updateColony(id, colony);
        if (updatedColony != null) {
            return ResponseEntity.ok(updatedColony);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/colonia/{id}")
    public ResponseEntity<Void> deleteColony(@PathVariable Long id) {
        colonyService.deleteColony(id);
        return ResponseEntity.ok().build();
    }
} 