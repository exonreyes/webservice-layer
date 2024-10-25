package nova.domain.entity.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nova.domain.entity.Area;

import java.io.Serializable;

/**
 * DTO for {@link Area}
 */
@AllArgsConstructor
@Getter
public class AreaQuery implements Serializable {
    private final Integer id;
    private final String nombre;
}