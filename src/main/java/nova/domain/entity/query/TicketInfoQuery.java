package nova.domain.entity.query;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class TicketInfoQuery implements Serializable {
    private final Integer id;
    private final String unidad;
    private final String reporte;
    private final String area;
    private final String folio;
    private final String agente;
    private final String estatus;
    private final LocalDateTime creado;

    public TicketInfoQuery(Integer id, String unidadClave, String unidadNombre, String reporteNombre, String area, String folio, String agente, String estatus, LocalDateTime creado) {
        this.id = id;
        this.agente = agente;
        this.unidad = unidadClave + " " + unidadNombre;
        this.reporte = reporteNombre;
        this.area = area;
        this.folio = folio;
        this.estatus = estatus;
        this.creado = creado;
    }
}
