package nova.business.service;

import nova.domain.entity.Area;
import nova.domain.entity.query.AreaQuery;

import java.util.List;

public interface IAreaService {
    List<AreaQuery> getAreas();

    List<Area> getAreasWithReportes();
}
