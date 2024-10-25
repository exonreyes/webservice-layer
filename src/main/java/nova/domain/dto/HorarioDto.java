package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.domain.entity.Horario;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link Horario}
 */
@AllArgsConstructor
@Getter
public class HorarioDto implements Serializable {
    private final Integer id;
    private final UnidadDto unidad;
    private final LocalTime apertura;
    private final LocalTime cierre;
}