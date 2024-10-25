package nova.business.facade;

import lombok.RequiredArgsConstructor;
import nova.business.mapper.OperatividadMapper;
import nova.business.service.IOperatividadService;
import nova.domain.dto.OperatividadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatividadFacadeImpl implements OperatividadFacade {
    private final IOperatividadService service;
    private final OperatividadMapper mapper;

    @Override
    public List<OperatividadDto> getAll() {
        return mapper.toDto(service.getAll());
    }
}
