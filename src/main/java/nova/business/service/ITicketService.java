package nova.business.service;

import nova.business.util.TicketFiltro;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;

import java.util.Map;

public interface ITicketService {
    Map<String, Object> buscarTicketsConFiltro(TicketFiltro filtro);

    TicketDetallesQuery getDetallesById(Integer id);

    Ticket getDetallesByFolio(String folio);
}
