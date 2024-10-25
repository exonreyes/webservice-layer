package nova.business.service;

import lombok.RequiredArgsConstructor;
import nova.business.mapper.TicketMapper;
import nova.business.util.TicketFiltro;
import nova.common.EntityException;
import nova.domain.entity.query.TicketDetallesQuery;
import nova.persistence.TicketRepository;
import nova.persistence.TicketRepositoryCustom;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {
    private final TicketRepository ticketRepository;
    private final TicketRepositoryCustom repository;
    private final TicketMapper mapper;

    public Map<String, Object> searchTicketsByFiltro(TicketFiltro filtro) {

        Pageable pageable = PageRequest.of(filtro.getPage(), filtro.getSize(), Sort.by(filtro.getOrderBy() != null ? filtro.getOrderBy() : "creado").descending());
        return repository.findByFiltro(filtro);
    }

    @Override
    public TicketDetallesQuery getDetallesById(Integer id) {
        return ticketRepository.findById(id, TicketDetallesQuery.class).orElseThrow(() -> new EntityException("E1005", "No se encontró el ticket especificado"));
    }

    @Override
    public TicketDetallesQuery getDetallesByFolio(String folio) {
        return ticketRepository.findByFolio(folio).orElseThrow(() -> new EntityException("E1005","No se encontró el ticket especificado"));
    }
}
