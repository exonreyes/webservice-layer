package nova.business.mapper;

import nova.domain.dto.ContactoUnidadDto;
import nova.domain.dto.UnidadDto;
import nova.domain.entity.Unidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnidadMapper {

    List<UnidadDto> toDto(List<Unidad> unidades);

    UnidadDto toDto(Unidad unidad);
}