package nova.business.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nova.business.service.factory.TicketFactory;
import nova.common.EntityException;
import nova.domain.entity.ActividadTicket;
import nova.persistence.ActividadTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActividadServiceImpl implements IActividadService {
    private final ActividadTicketRepository repository;

    @Override
    public List<ActividadTicket> getActividades(Integer ticketId) {
        return repository.findByTicket_Id(ticketId);
    }

    @Override
    @Transactional
    public void addActividad(ActividadTicket newActividad) {
        var data = TicketFactory.createActividadTicket(newActividad);
        try {
            repository.save(data);
        } catch (Exception e) {
            throw new EntityException("E1003", "Error al registra la actividad");
        }

    }
}
