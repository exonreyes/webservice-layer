package nova.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

/**
 * DTO for {@link nova.domain.entity.Operatividad}
 */
@AllArgsConstructor
@Getter
public class OperatividadDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final Set<HorarioDto1> horarios;
    @AllArgsConstructor
    @Getter
    public static class HorarioDto1 implements Serializable {
        private final Integer id;
        private final OperatividadDto.HorarioDto1.UnidadDto1 unidad;
        private final LocalTime apertura;
        private final LocalTime cierre;
        @AllArgsConstructor
        @Getter
        public static class UnidadDto1 implements Serializable {
            private final Integer id;
            @NotNull
            @Size(max = 10)
            private final String clave;
            @NotNull
            @Size(max = 100)
            private final String nombre;
        }
    }
}