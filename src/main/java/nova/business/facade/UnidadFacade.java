package nova.business.facade;

import nova.domain.dto.UnidadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnidadFacade {
    List<UnidadDto> getUnidades();

    UnidadDto getContacto(Integer idUnidad);
}
