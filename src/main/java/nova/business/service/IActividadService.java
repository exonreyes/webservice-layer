package nova.business.service;

import nova.domain.entity.ActividadTicket;

import java.util.List;

public interface IActividadService {
    List<ActividadTicket> getActividades(Integer ticketId);

    void addActividad(ActividadTicket actividadCommand);
}
