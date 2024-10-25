package nova.business.facade;

import nova.domain.dto.TicketDto;
import nova.domain.dto.UnidadDto;
import nova.domain.entity.Ticket;
import nova.presentation.controller.request.TicketFiltroRequest;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface TicketFacade {
    Map<String,Object> getByFiltro(TicketFiltroRequest request);
    TicketDto getDetallesById(Integer id);
    TicketDto getDetallesByFolio(String folio);
}
