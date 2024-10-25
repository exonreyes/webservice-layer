package nova.business.facade;

import nova.domain.dto.EstatusDto;

import java.util.List;

public interface EstatusFacade {
    List<EstatusDto> getEstatus();
}
