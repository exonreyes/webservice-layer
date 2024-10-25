package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.domain.entity.Area;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Area}
 */
@AllArgsConstructor
@Getter
public class AreaDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final Set<ReporteDto> reportes;
}