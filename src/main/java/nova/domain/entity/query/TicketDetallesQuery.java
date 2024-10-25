package nova.domain.entity.query;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link nova.domain.entity.Ticket}
 */
@AllArgsConstructor
@Getter
public class TicketDetallesQuery implements Serializable {
    private final Integer id;
    private final Integer unidadId;
    private final String unidadClave;
    private final String unidadNombre;
    private final Integer estatusId;
    private final String estatusNombre;
    private final Integer reporteId;
    private final Integer reporteAreaId;
    private final String reporteAreaNombre;
    private final String reporteNombre;
    private final Integer usuarioId;
    private final String usuarioClave;
    private final String usuarioNombre;
    private final String folio;
    private final String agente;
    private final String comentario;
    private final Instant creado;
}