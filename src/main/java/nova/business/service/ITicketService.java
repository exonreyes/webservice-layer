package nova.business.service;

import nova.business.util.TicketFiltro;
import nova.common.PageData;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;
import nova.domain.entity.query.TicketInfoQuery;

public interface ITicketService {
    PageData<TicketInfoQuery> searchTicketsByFiltro(TicketFiltro filtro);

    TicketInfoQuery getInfoById(Integer id);

    TicketDetallesQuery getDetallesById(Integer id);

    TicketDetallesQuery getDetallesByFolio(String folio);

    Ticket addTicket(Ticket ticket);

}
