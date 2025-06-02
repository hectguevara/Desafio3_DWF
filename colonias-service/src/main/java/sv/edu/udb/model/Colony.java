package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colonias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "coordenada_x")
    private Double coordenadaX;
    
    @Column(name = "coordenada_y")
    private Double coordenadaY;
    
    @Column(name = "coordenada_z")
    private Double coordenadaZ;
    
    @Column(name = "poblacion")
    private Integer poblacion;
    
    @Column(name = "recursos_naturales")
    private String recursosNaturales;
    
    @Column(name = "tecnologia")
    private String tecnologia;
    
    @Column(name = "alianzas_politicas")
    private String alianzasPoliticas;
    
    @Column(name = "activa")
    private Boolean activa = true;
} 