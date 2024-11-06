package nova.business.mapper;

import nova.domain.dto.ActividadTicketDto;
import nova.domain.dto.TicketDto;
import nova.domain.entity.ActividadTicket;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;
import nova.domain.entity.query.TicketInfoQuery;
import nova.presentation.controller.request.ActividadCreateRequest;
import nova.presentation.controller.request.TicketCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    @Mapping(target = "area.id", source = "reporteAreaId")
    @Mapping(target = "area.nombre", source = "reporteAreaNombre")
    @Mapping(target = "reporte.id", source = "reporteId")
    @Mapping(target = "reporte.nombre", source = "reporteNombre")
    @Mapping(target = "creado", source = "creado")
    @Mapping(target = "estatus.id", source = "estatusId")
    @Mapping(target = "estatus.nombre", source = "estatusNombre")
    @Mapping(target = "unidad.id", source = "unidadId")
    @Mapping(target = "unidad.clave", source = "unidadClave")
    @Mapping(target = "unidad.nombre", source = "unidadNombre")
    TicketDto queryToDto(TicketDetallesQuery ticket);

    ActividadTicketDto actividadToDto(ActividadTicket actividadTicket);

    @Mapping(target = "unidad.id", source = "unidadId")
    @Mapping(target = "reporte.id", source = "reporteId")
    @Mapping(target = "estatus.id", source = "estatusId")
    @Mapping(target = "usuario.id", source = "usuarioId")
    Ticket commandToTicketEntity(TicketCreateRequest ticketCommand);

    @Mapping(target = "estatus.id", source = "estatusId")
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "ticket.id", source = "ticketId")
    @Mapping(target = "creado", expression = "java(LocalDateTime.now())")
    ActividadTicket commandToEntityActividad(ActividadCreateRequest command);

    @Mapping(target = "reporte.nombre", source = "reporteNombre")
    @Mapping(target = "reporte.id", source = "reporteId")
    @Mapping(target = "area.nombre", source = "reporteAreaNombre")
    @Mapping(target = "area.id", source = "reporteAreaId")
    @Mapping(target = "estatus.id", source = "estatusId")
    @Mapping(target = "estatus.nombre", source = "estatusNombre")
    @Mapping(target = "unidad.clave", source = "unidadClave")
    @Mapping(target = "unidad.nombre", source = "unidadNombre")
    TicketDto infoQueryToDto(TicketInfoQuery ticketInfoQuery);
}