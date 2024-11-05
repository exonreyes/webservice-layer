package nova.business.facade;

import nova.domain.dto.ActividadTicketDto;
import nova.domain.dto.TicketDto;
import nova.presentation.controller.request.ActividadCreateRequest;
import nova.presentation.controller.request.TicketCreateRequest;
import nova.presentation.controller.request.TicketFiltroRequest;

import java.util.List;
import java.util.Map;

public interface TicketFacade {
    Map<String, Object> getByFiltro(TicketFiltroRequest request);

    TicketDto getDetallesById(Integer id);

    TicketDto getDetallesByFolio(String folio);

    List<ActividadTicketDto> getActividades(Integer ticketId);

    Void addActividad(ActividadCreateRequest params);

    TicketDto addTicket(TicketCreateRequest params);
}
