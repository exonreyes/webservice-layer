package nova.business.mapper;

import nova.domain.dto.OperatividadDto;
import nova.domain.entity.Operatividad;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OperatividadMapper {


    @AfterMapping
    default void linkHorarios(@MappingTarget Operatividad operatividad) {
        operatividad.getHorarios().forEach(horario -> horario.setOperatividad(operatividad));
    }

    OperatividadDto toDto(Operatividad operatividad);

    List<OperatividadDto> toDto(List<Operatividad> operatividad);
}