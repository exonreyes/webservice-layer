package nova.domain.entity.query;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

@Getter
public class TicketInfoQuery implements Serializable {
    private final Integer id;
    private final String unidad;
    private final String reporte;
    private final String area;
    private final String folio;
    private final String comentario;
    private final Instant creado;

    public TicketInfoQuery(Integer id, String unidadClave, String unidadNombre, String reporteNombre, String area, String folio, String comentario, Instant creado) {
        this.id = id;
        this.unidad = unidadClave+" " + unidadNombre;
        this.reporte = reporteNombre;
        this.area = area;
        this.folio = folio;
        this.comentario = comentario;
        this.creado = creado;
    }
    // Getters y setters si es necesario
}
