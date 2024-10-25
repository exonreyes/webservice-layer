package nova.presentation.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Builder
public class TicketFiltroRequest {
    private Integer unidadId;
    private Integer estatusId;
    private Integer areaId;

    @NotNull(message = "Debe asignar una pagina a consultar")
    private Integer page;

    @NotNull(message = "Debe asignar el número de filas a consultar")
    @Min(value = 1)
    private Integer size;

    private String folio;

    @PastOrPresent
    private Instant desde;

    private Instant hasta;
}
