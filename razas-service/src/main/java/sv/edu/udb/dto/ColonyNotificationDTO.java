package sv.edu.udb.dto;

import lombok.Data;

@Data
public class ColonyNotificationDTO {
    private Long id;
    private String nombre;
    private Integer poblacion;
    private Long razaId;
} 