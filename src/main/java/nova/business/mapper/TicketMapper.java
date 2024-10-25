package nova.business.mapper;

import nova.domain.dto.TicketDto;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    @Mapping(target = "area", source = "reporte.area")
    @Mapping(target = "reporte", source = "reporte")
    TicketDto toDto(Ticket ticket);

    @Mapping(source = "usuarioNombre", target = "usuario.nombre")
    @Mapping(source = "usuarioClave", target = "usuario.clave")
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "reporteNombre", target = "reporte.nombre")
    @Mapping(source = "reporteAreaNombre", target = "area.nombre")
    @Mapping(source = "reporteAreaId", target = "area.id")
    @Mapping(source = "reporteId", target = "reporte.id")
    @Mapping(source = "estatusNombre", target = "estatus.nombre")
    @Mapping(source = "estatusId", target = "estatus.id")
    @Mapping(source = "unidadNombre", target = "unidad.nombre")
    @Mapping(source = "unidadClave", target = "unidad.clave")
    @Mapping(source = "unidadId", target = "unidad.id")
    TicketDto queryToDto(TicketDetallesQuery ticket);
}