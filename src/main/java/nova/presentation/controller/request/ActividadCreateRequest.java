package nova.presentation.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ActividadCreateRequest {
    @NotNull
    @Min(value = 1)
    private Integer usuarioId;
    private String agente;
    @NotNull
    @Min(value = 1)
    private Integer estatusId;
    private String comentario;
    @NotNull
    @Min(value = 1)
    private Integer ticketId;
}