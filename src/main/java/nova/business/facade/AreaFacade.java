package nova.business.facade;

import nova.domain.dto.AreaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaFacade {
    List<AreaDto> getAreas();

    List<AreaDto> getAreasWithReportes();
}
