package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.domain.entity.Reporte;

import java.io.Serializable;

/**
 * DTO for {@link Reporte}
 */
@AllArgsConstructor
@Getter
public class ReporteDto implements Serializable {
    private final Integer id;
    private final String nombre;

}