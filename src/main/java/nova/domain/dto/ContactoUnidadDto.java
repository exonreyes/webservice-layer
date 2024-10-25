package nova.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ContactoUnidadDto implements Serializable {
    private final Integer id;
    private final String telefono;
    private final String direccion;
}