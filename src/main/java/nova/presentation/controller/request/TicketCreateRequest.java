package nova.presentation.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class TicketCreateRequest {
    @NotNull
    private Integer reporteId, unidadId, estatusId, usuarioId;
    private String folio;
    private String agente;
    private String comentario;
}