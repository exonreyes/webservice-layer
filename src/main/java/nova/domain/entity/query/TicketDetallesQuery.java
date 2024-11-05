package nova.domain.entity.query;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link nova.domain.entity.Ticket}
 */
public record TicketDetallesQuery(Integer id, Integer unidadId, String unidadClave, String unidadNombre,
                                  Integer estatusId, String estatusNombre, Integer reporteId, Integer reporteAreaId,
                                  String reporteAreaNombre, String reporteNombre, Integer usuarioId,
                                  String usuarioClave, String usuarioNombre, String folio, String agente,
                                  String comentario, LocalDateTime creado) implements Serializable {
}