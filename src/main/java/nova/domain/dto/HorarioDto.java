package nova.domain.dto;

import nova.domain.entity.Horario;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link Horario}
 */

public record HorarioDto(Integer id, UnidadDto unidad, LocalTime apertura, LocalTime cierre) implements Serializable {
}