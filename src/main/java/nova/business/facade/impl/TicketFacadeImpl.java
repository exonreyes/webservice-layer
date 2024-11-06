package nova.business.facade.impl;

import lombok.RequiredArgsConstructor;
import nova.business.facade.TicketFacade;
import nova.business.mapper.TicketMapper;
import nova.business.service.IActividadService;
import nova.business.service.ITicketService;
import nova.business.service.impl.TicketFolioValidatorService;
import nova.business.util.TicketFiltro;
import nova.common.PageData;
import nova.domain.dto.ActividadTicketDto;
import nova.domain.dto.TicketDto;
import nova.presentation.controller.request.ActividadCreateRequest;
import nova.presentation.controller.request.TicketCreateRequest;
import nova.presentation.controller.request.TicketFiltroRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketFacadeImpl implements TicketFacade {
    private final TicketFolioValidatorService folioValidatorService;
    private final ITicketService ticketService;
    private final IActividadService actividadService;
    private final TicketMapper mapper;

    @Override
    public PageData<TicketDto> getByFiltro(TicketFiltroRequest filter) {
        TicketFiltro filtro = TicketFiltro.builder().page(filter.getPage()).size(filter.getSize()).unidadId(filter.getUnidadId()).estatusId(filter.getEstatusId()).desde(filter.getDesde()).hasta(filter.getHasta()).areaId(filter.getAreaId()).folio(filter.getFolio()).build();
        var data = ticketService.searchTicketsByFiltro(filtro);
        List<TicketDto> list = data.getData().parallelStream().map(mapper::infoQueryToDto).toList();
        PageData<TicketDto> result = new PageData<>(list, data.getPage());
        return result;
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
        return mapper.infoQueryToDto(ticketService.getInfoById(data.getId()));
    }
}