package nova.business.facade;

import lombok.RequiredArgsConstructor;
import nova.business.mapper.AreaMapper;
import nova.business.service.IAreaService;
import nova.domain.dto.AreaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaFacadeImpl implements AreaFacade {
    private final IAreaService service;
    private final AreaMapper mapper;

    @Override
    public List<AreaDto> getAreas() {
        return mapper.queryToDto(service.getAreas());
    }

    @Override
    public List<AreaDto> getAreasWithReportes() {
        return mapper.toDto(service.getAreasWithReportes());
    }
}
