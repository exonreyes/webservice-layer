package nova.persistence;

import nova.domain.entity.ActividadTicket;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadTicketRepository extends JpaRepository<ActividadTicket, Integer> {
    @EntityGraph(attributePaths = {"estatus", "usuario"})
    List<ActividadTicket> findByTicket_Id(Integer id);

}