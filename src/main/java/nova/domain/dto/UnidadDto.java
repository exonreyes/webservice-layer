package nova.domain.dto;

import nova.domain.entity.Unidad;

import java.io.Serializable;

/**
 * DTO for {@link Unidad}
 */
public record UnidadDto(Integer id, String clave, String nombre, ContactoUnidadDto contacto) implements Serializable {
}