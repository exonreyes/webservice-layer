package nova.domain.dto;

import nova.domain.entity.Reporte;

import java.io.Serializable;

/**
 * DTO for {@link Reporte}
 */
public record ReporteDto(Integer id, String nombre) implements Serializable {
}