package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.domain.entity.Unidad;

import java.io.Serializable;

/**
 * DTO for {@link Unidad}
 */
@AllArgsConstructor
@Getter
public class UnidadDto implements Serializable {
    private final Integer id;
    private final String clave;
    private final String nombre;
    private final ContactoUnidadDto contacto;
}