package nova.domain.dto;

import java.io.Serializable;

public record ContactoUnidadDto(Integer id, String telefono, String direccion) implements Serializable {
}