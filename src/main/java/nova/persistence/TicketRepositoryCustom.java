package nova.persistence;

import nova.business.util.TicketFiltro;
import nova.common.PageData;
import nova.domain.entity.query.TicketInfoQuery;

public interface TicketRepositoryCustom {
    PageData<TicketInfoQuery> findByFiltro(TicketFiltro filtro);
}
