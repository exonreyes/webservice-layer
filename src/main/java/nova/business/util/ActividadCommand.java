package nova.business.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ActividadCommand {
    private Integer usuarioId, ticketId, estatusId;
    private String comentario, agente;
    private Instant creado;
}
