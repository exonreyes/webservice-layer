package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.domain.entity.Estatus;

import java.io.Serializable;

/**
 * DTO for {@link Estatus}
 */
@AllArgsConstructor
@Getter
public class EstatusDto implements Serializable {
    private final Integer id;
    private final String nombre;
}