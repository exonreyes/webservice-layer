package nova.business.facade;

import lombok.RequiredArgsConstructor;
import nova.business.mapper.TicketMapper;
import nova.business.service.ITicketService;
import nova.business.util.TicketFiltro;
import nova.domain.dto.TicketDto;
import nova.presentation.controller.request.TicketFiltroRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TicketFacadeImpl implements TicketFacade {
    private final ITicketService service;
    private final TicketMapper mapper;

    @Override
    public Map<String, Object> getByFiltro(TicketFiltroRequest filter) {
        TicketFiltro filtro = TicketFiltro.builder()
                .page(filter.getPage())
                .size(filter.getSize())
                .unidadId(filter.getUnidadId())
                .estatusId(filter.getEstatusId())
                .desde(filter.getDesde())
                .hasta(filter.getHasta())
                .areaId(filter.getAreaId())
                .folio(filter.getFolio())
                .build();
        return service.buscarTicketsConFiltro(filtro);
    }

    @Override
    public TicketDto getDetallesById(Integer id) {
        return mapper.queryToDto(service.getDetallesById(id));
    }

    @Override
    public TicketDto getDetallesByFolio(String folio) {
        return mapper.toDto(service.getDetallesByFolio(folio));
    }

}
