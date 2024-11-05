package nova.business.service.factory;

import nova.business.service.builder.FolioBuilder;
import nova.domain.entity.ActividadTicket;
import nova.domain.entity.Ticket;

import java.time.LocalDateTime;
import java.util.Optional;

public final class TicketFactory {
    public static ActividadTicket createActividadTicket(ActividadTicket command) {
        command.setCreado(LocalDateTime.now());
        return command;
    }

    public static Ticket createTicket(Ticket data) {
        data.setAgente((Optional.ofNullable(data.getAgente())
                .filter(agente -> !agente.isBlank())
                .orElse(null)));
        data.setFolio(Optional.ofNullable(data.getFolio())
                .filter(folio -> !folio.isBlank())
                .orElse(FolioBuilder.build()));
        data.setCreado(LocalDateTime.now());
        return data;
    }
}
