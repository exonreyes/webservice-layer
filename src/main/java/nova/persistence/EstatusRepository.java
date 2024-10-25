package nova.persistence;

import nova.domain.entity.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusRepository extends JpaRepository<Estatus, Integer> {
}