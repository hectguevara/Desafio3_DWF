package sv.edu.udb.dto;

import lombok.Data;
import sv.edu.udb.model.Colony;

@Data
public class ColonyResponseDTO {
    private Long id;
    private String nombre;
    private Double coordenadaX;
    private Double coordenadaY;
    private Double coordenadaZ;
    private Integer poblacion;
    private String recursosNaturales;
    private String tecnologia;
    private String alianzasPoliticas;
    private Boolean activa;
    private RazaDTO raza;

    public static ColonyResponseDTO fromColony(Colony colony, RazaDTO raza) {
        ColonyResponseDTO dto = new ColonyResponseDTO();
        dto.setId(colony.getId());
        dto.setNombre(colony.getNombre());
        dto.setCoordenadaX(colony.getCoordenadaX());
        dto.setCoordenadaY(colony.getCoordenadaY());
        dto.setCoordenadaZ(colony.getCoordenadaZ());
        dto.setPoblacion(colony.getPoblacion());
        dto.setRecursosNaturales(colony.getRecursosNaturales());
        dto.setTecnologia(colony.getTecnologia());
        dto.setAlianzasPoliticas(colony.getAlianzasPoliticas());
        dto.setActiva(colony.getActiva());
        dto.setRaza(raza);
        return dto;
    }
} 