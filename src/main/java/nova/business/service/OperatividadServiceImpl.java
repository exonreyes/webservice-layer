package nova.business.service;

import lombok.RequiredArgsConstructor;
import nova.domain.entity.Operatividad;
import nova.persistence.OperatividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatividadServiceImpl implements IOperatividadService {
    private final OperatividadRepository repository;

    @Override
    public List<Operatividad> getAll() {
        return repository.findAll();
    }
}
