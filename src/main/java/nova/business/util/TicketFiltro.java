package nova.business.util;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class TicketFiltro {
    private Integer unidadId;
    private Integer estatusId;
    private Integer areaId;
    private Integer page;
    private String orderBy;
    private Integer size;
    private String folio;
    private LocalDateTime desde;
    private LocalDateTime hasta;
}
