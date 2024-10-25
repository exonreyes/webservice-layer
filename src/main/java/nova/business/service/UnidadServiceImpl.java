package nova.business.service;

import lombok.RequiredArgsConstructor;
import nova.common.EntityException;
import nova.domain.entity.ContactoUnidad;
import nova.domain.entity.Unidad;
import nova.persistence.ContactoUnidadRepository;
import nova.persistence.UnidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadServiceImpl implements IUnidadService {
    private final UnidadRepository repository;
    private final ContactoUnidadRepository contactoRepository;

    @Override
    public List<Unidad> getUnidades() {
        return repository.findAll();
    }

    @Override
    public ContactoUnidad getContacto(Integer id) {
        return contactoRepository.findByUnidad_Id(id).orElseThrow(() -> new EntityException("E1004", "No se encontró la unidad especificada"));
    }
}
