package nova.domain.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

/**
 * DTO for {@link nova.domain.entity.Operatividad}
 */
public record OperatividadDto(Integer id, String nombre, Set<HorarioDto1> horarios) implements Serializable {
    public record HorarioDto1(Integer id, OperatividadDto.HorarioDto1.UnidadDto1 unidad, LocalTime apertura,
                              LocalTime cierre) implements Serializable {
        public record UnidadDto1(Integer id, String clave, String nombre) implements Serializable {
        }
    }
}