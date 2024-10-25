package nova.business.mapper;

import nova.domain.dto.EstatusDto;
import nova.domain.entity.Estatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstatusMapper {

    List<EstatusDto> toDto(List<Estatus> estatus);
}