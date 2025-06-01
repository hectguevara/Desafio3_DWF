package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Colony;

public interface ColonyRepository extends JpaRepository<Colony, Long> {
} 