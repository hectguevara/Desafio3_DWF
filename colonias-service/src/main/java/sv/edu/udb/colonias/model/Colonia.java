package sv.edu.udb.colonias.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colonias")
public class Colonia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private Double coordenadaX;
    
    @Column(nullable = false)
    private Double coordenadaY;
    
    @Column(nullable = false)
    private Double coordenadaZ;
    
    @Column(nullable = false)
    private Long poblacion;
    
    @Column(columnDefinition = "TEXT")
    private String recursosNaturales;
    
    @Column(columnDefinition = "TEXT")
    private String tecnologia;
    
    @Column(columnDefinition = "TEXT")
    private String alianzasPoliticas;
    
    @Column(nullable = false)
    private Boolean activa = true;
    
    @Column(updatable = false)
    private java.time.LocalDateTime fechaCreacion;
    
    @Column
    private java.time.LocalDateTime fechaActualizacion;
    
    @PrePersist
    protected void onCreate() {
        fechaCreacion = java.time.LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = java.time.LocalDateTime.now();
    }
} 