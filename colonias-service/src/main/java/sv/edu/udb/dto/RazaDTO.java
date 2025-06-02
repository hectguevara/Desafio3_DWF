package sv.edu.udb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RazaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer nivelTecnologico;
    private Long poblacionTotal;
    private String planetaOrigen;
} 