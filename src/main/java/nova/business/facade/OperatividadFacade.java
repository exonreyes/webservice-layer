package nova.business.facade;

import nova.domain.dto.OperatividadDto;

import java.util.List;

public interface OperatividadFacade {
    List<OperatividadDto> getAll();
}
