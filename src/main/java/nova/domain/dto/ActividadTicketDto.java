package nova.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link nova.domain.entity.ActividadTicket}
 */
public record ActividadTicketDto(Integer id, EstatusDto estatus, UsuarioDto usuario, String agente, String comentario,
                                 LocalDateTime creado) implements Serializable {
}