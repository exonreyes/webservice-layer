package nova.domain.entity.query;

import nova.domain.entity.Area;

import java.io.Serializable;

/**
 * DTO for {@link Area}
 */
public record AreaQuery(Integer id, String nombre) implements Serializable {
}