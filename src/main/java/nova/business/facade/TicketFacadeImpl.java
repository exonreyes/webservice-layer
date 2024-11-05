package nova.business.facade;

import lombok.RequiredArgsConstructor;
import nova.business.mapper.TicketMapper;
import nova.business.service.IActividadService;
import nova.business.service.ITicketService;
import nova.business.service.TicketFolioValidatorService;
import nova.business.util.TicketFiltro;
import nova.domain.dto.ActividadTicketDto;
import nova.domain.dto.TicketDto;
import nova.presentation.controller.request.ActividadCreateRequest;
import nova.presentation.controller.request.TicketCreateRequest;
import nova.presentation.controller.request.TicketFiltroRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TicketFacadeImpl implements TicketFacade {
    private final TicketFolioValidatorService folioValidatorService;
    private final ITicketService ticketService;
    private final IActividadService actividadService;
    private final TicketMapper mapper;

    @Override
    public Map<String, Object> getByFiltro(TicketFiltroRequest filter) {
        TicketFiltro filtro = TicketFiltro.builder().page(filter.getPage()).size(filter.getSize()).unidadId(filter.getUnidadId()).estatusId(filter.getEstatusId()).desde(filter.getDesde()).hasta(filter.getHasta()).areaId(filter.getAreaId()).folio(filter.getFolio()).build();
        return ticketService.searchTicketsByFiltro(filtro);
    }

    @Override
    public TicketDto getDetallesById(Integer id) {
        return mapper.queryToDto(ticketService.getDetallesById(id));
    }

    @Override
    public TicketDto getDetallesByFolio(String folio) {
        return mapper.queryToDto(ticketService.getDetallesByFolio(folio));
    }

    @Override
    public List<ActividadTicketDto> getActividades(Integer id) {
        return actividadService.getActividades(id).stream().map(mapper::actividadToDto).toList();
    }

    @Override
    public Void addActividad(ActividadCreateRequest params) {
        actividadService.addActividad(mapper.commandToEntityActividad(params));
        return null;
    }

    @Override
    public TicketDto addTicket(TicketCreateRequest params) {
        folioValidatorService.execute(params.getFolio());
        var data = ticketService.addTicket(mapper.commandToTicketEntity(params));

        return mapper.toDto(data);
    }
}