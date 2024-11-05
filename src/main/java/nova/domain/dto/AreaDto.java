package nova.domain.dto;

import nova.domain.entity.Area;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Area}
 */

public record AreaDto(Integer id, String nombre, Set<ReporteDto> reportes) implements Serializable {
}