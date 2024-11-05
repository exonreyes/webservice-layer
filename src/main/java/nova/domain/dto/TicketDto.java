package nova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nova.domain.entity.Ticket;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Ticket}
 */
@AllArgsConstructor
@Getter
public class TicketDto implements Serializable {
    private final Integer id;
    private final UnidadDto unidad;
    private final EstatusDto estatus;
    private final AreaDto area;
    private final ReporteDto reporte;
    private final UsuarioDto usuario;
    private final String folio;
    private final String agente;
    private final String comentario;
    private final LocalDateTime creado;
    private final LocalDateTime actualizado;
    private final Boolean publicar;
    @Setter
    private List<ActividadTicketDto> actividades;

}