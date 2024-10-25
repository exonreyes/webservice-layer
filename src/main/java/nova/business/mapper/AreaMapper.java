package nova.business.mapper;

import nova.domain.dto.AreaDto;
import nova.domain.entity.Area;
import nova.domain.entity.query.AreaQuery;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaMapper {
    List<AreaDto> queryToDto(List<AreaQuery> areas);

    List<AreaDto> toDto(List<Area> areas);

}