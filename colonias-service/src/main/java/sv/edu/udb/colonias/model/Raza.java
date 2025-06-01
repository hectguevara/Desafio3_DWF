package sv.edu.udb.colonias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String tecnologiasAvanzadas;
    private String aliados;
    private String enemigos;
    private String datosPoliticos;
}
