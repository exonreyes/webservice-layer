package nova.domain.entity.query;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link nova.domain.entity.Ticket}
 */
public record TicketInfoQuery(Integer id, String unidadClave, String unidadNombre, Integer estatusId,
                              String estatusNombre, Integer reporteId, String reporteNombre, Integer reporteAreaId,
                              String reporteAreaNombre, String folio, String agente,
                              LocalDateTime creado) implements Serializable {
}