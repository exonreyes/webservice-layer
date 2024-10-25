package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class UsuarioDto implements Serializable {
    private final Integer id;
    private final String clave;
    private final String nombre;
}