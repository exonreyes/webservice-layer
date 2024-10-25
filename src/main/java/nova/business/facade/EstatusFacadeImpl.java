package nova.business.facade;

import lombok.RequiredArgsConstructor;
import nova.business.mapper.EstatusMapper;
import nova.business.service.IEstatusService;
import nova.domain.dto.EstatusDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatusFacadeImpl implements EstatusFacade {
    private final IEstatusService service;
    private final EstatusMapper mapper;

    @Override
    public List<EstatusDto> getEstatus() {
        return mapper.toDto(service.getEstatus());
    }
}
