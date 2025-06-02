package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "razas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "nivel_tecnologico", nullable = false)
    private Integer nivelTecnologico;

    @Column(name = "poblacion_total", nullable = false)
    private Long poblacionTotal;

    @Column(name = "planeta_origen", nullable = false)
    private String planetaOrigen;
} 