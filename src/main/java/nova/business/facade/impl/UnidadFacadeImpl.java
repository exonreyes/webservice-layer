package nova.business.facade.impl;

import lombok.RequiredArgsConstructor;
import nova.business.facade.UnidadFacade;
import nova.business.mapper.UnidadMapper;
import nova.business.service.IUnidadService;
import nova.domain.dto.ContactoUnidadDto;
import nova.domain.dto.UnidadDto;
import nova.domain.entity.ContactoUnidad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadFacadeImpl implements UnidadFacade {
    private final IUnidadService service;
    private final UnidadMapper mapper;

    @Override
    public List<UnidadDto> getUnidades() {
        return mapper.toDto(service.getUnidades());
    }

    @Override
    public UnidadDto getContacto(Integer idUnidad) {
        ContactoUnidad data = service.getContacto(idUnidad);
        var unidad = data.getUnidad();
        var contactoUnidadDto = new ContactoUnidadDto(data.getId(), data.getTelefono(), data.getDireccion());
        return new UnidadDto(unidad.getId(), unidad.getClave(), unidad.getNombre(), contactoUnidadDto);
    }
}
