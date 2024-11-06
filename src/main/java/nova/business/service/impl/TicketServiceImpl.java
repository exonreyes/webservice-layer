package nova.business.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nova.business.service.ITicketService;
import nova.business.service.factory.TicketFactory;
import nova.business.util.TicketFiltro;
import nova.common.EntityException;
import nova.common.PageData;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;
import nova.domain.entity.query.TicketInfoQuery;
import nova.persistence.TicketRepository;
import nova.persistence.TicketRepositoryCustom;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {
    private final TicketRepository ticketRepository;
    private final TicketRepositoryCustom customRepository;

    public PageData<TicketInfoQuery> searchTicketsByFiltro(TicketFiltro filtro) {
        return customRepository.findByFiltro(filtro);
    }

    @Override
    public TicketInfoQuery getInfoById(Integer id) {
        return ticketRepository.findById(id, TicketInfoQuery.class).orElseThrow(() -> new EntityException("E1005", "No se encontró el ticket especificado"));
    }

    @Override
    public TicketDetallesQuery getDetallesById(Integer id) {
        return ticketRepository.findById(id, TicketDetallesQuery.class).orElseThrow(() -> new EntityException("E1005", "No se encontró el ticket especificado"));
    }

    @Override
    public TicketDetallesQuery getDetallesByFolio(String folio) {
        return ticketRepository.findByFolio(folio).orElseThrow(() -> new EntityException("E1005", "No se encontró el ticket especificado"));
    }

    @Override
    @Transactional
    public Ticket addTicket(Ticket ticket) {
        try {
            return ticketRepository.save(TicketFactory.createTicket(ticket));
        } catch (Exception e) {
            throw new EntityException("E1002", "Error interno al guardar el ticket");
        }
    }

}
