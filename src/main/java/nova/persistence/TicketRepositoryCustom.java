package nova.persistence;

import nova.business.util.TicketFiltro;

import java.util.Map;

public interface TicketRepositoryCustom {
    Map<String, Object> findByFiltro(TicketFiltro filtro);
}
