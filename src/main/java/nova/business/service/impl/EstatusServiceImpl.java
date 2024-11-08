package nova.business.service.impl;

import lombok.RequiredArgsConstructor;
import nova.business.service.IEstatusService;
import nova.domain.entity.Estatus;
import nova.persistence.EstatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatusServiceImpl implements IEstatusService {
    private final EstatusRepository repository;

    @Override
    public List<Estatus> getEstatus() {
        return repository.findAll();
    }
}
