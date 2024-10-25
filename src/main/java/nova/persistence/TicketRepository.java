package nova.persistence;

import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketDetallesQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    <T> Optional<T> findById(Integer integer, Class<T> type);

    Optional<TicketDetallesQuery> findByFolio(String folio);

}