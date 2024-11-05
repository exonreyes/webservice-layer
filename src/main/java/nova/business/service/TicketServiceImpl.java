package nova.business.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nova.business.mapper.TicketMapper;
import nova.business.service.factory.TicketFactory;
import nova.business.util.TicketFiltro;
import nova.common.EntityException;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;
import nova.persistence.TicketRepository;
import nova.persistence.TicketRepositoryCustom;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {
    private final TicketRepository ticketRepository;
    private final TicketRepositoryCustom customRepository;
    private final TicketMapper mapper;

    public Map<String, Object> searchTicketsByFiltro(TicketFiltro filtro) {
        return customRepository.findByFiltro(filtro);
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
