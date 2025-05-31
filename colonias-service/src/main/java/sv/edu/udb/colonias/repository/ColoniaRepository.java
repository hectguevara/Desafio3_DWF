package sv.edu.udb.colonias.repository;

import sv.edu.udb.colonias.model.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, Long> {
} 