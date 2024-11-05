package nova.domain.dto;

import nova.domain.entity.Estatus;

import java.io.Serializable;

/**
 * DTO for {@link Estatus}
 */
public record EstatusDto(Integer id, String nombre) implements Serializable {
}