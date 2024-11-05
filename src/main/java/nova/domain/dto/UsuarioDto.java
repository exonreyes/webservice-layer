package nova.domain.dto;

import java.io.Serializable;

public record UsuarioDto(Integer id, String clave, String nombre) implements Serializable {
}