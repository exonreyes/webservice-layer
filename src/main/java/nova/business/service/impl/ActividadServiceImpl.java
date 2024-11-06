package nova.business.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nova.business.service.IActividadService;
import nova.business.service.factory.TicketFactory;
import nova.common.EntityException;
import nova.domain.entity.ActividadTicket;
import nova.domain.entity.Estatus;
import nova.domain.entity.Ticket;
import nova.persistence.ActividadTicketRepository;
import nova.persistence.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActividadServiceImpl implements IActividadService {
    private final ActividadTicketRepository repository;
    private final TicketRepository ticketRepository;

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
            Optional<Ticket> ticketModel = ticketRepository.findById(data.getTicket().getId());
            if (ticketModel.isPresent()) {
                var tempTicket = ticketModel.get();
                tempTicket.setEstatus(new Estatus(newActividad.getEstatus().getId()));
                ticketRepository.save(tempTicket);
            } else {
                throw new EntityException("E1003", "No se pudo guardar, ticket no disponible");
            }
        } catch (Exception e) {
            throw new EntityException("E1003", "Error al registra la actividad");
        }

    }
}
