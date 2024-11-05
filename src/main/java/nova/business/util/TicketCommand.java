package nova.business.util;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TicketCommand {
    private Integer unidadId, estatusId, reporteId, usuarioId;
    private String agente, folio, comentario;
    private Instant creado;
}
