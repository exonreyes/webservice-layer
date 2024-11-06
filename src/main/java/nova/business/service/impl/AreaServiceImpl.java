package nova.business.service.impl;

import lombok.RequiredArgsConstructor;
import nova.business.service.IAreaService;
import nova.domain.entity.Area;
import nova.domain.entity.query.AreaQuery;
import nova.persistence.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements IAreaService {
    private final AreaRepository repository;

    @Override
    public List<AreaQuery> getAreas() {
        return repository.findBy(AreaQuery.class);
    }

    @Override
    public List<Area> getAreasWithReportes() {
        return repository.getAreasWithReportes();
    }
}
