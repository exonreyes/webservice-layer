package nova.persistence;

import nova.domain.entity.Ticket;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    <T> Optional<T> findById(Integer integer, Class<T> type);

    @EntityGraph(attributePaths = {"unidad", "estatus", "reporte.area", "usuario", "reporte"})
    Optional<Ticket> findByFolio(String folio);

}