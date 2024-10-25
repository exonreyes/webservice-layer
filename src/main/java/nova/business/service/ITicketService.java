package nova.business.service;

import nova.business.util.TicketFiltro;
import nova.domain.entity.query.TicketDetallesQuery;

import java.util.Map;

public interface ITicketService {
    Map<String, Object> searchTicketsByFiltro(TicketFiltro filtro);

    TicketDetallesQuery getDetallesById(Integer id);

    TicketDetallesQuery getDetallesByFolio(String folio);
}
