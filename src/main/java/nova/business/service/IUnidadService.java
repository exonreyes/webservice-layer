package nova.business.service;

import nova.domain.entity.ContactoUnidad;
import nova.domain.entity.Unidad;

import java.util.List;

public interface IUnidadService {
    List<Unidad> getUnidades();
    ContactoUnidad getContacto(Integer id);
}
