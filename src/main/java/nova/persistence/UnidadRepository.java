package nova.persistence;

import nova.domain.entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    <T> List<T> findBy(Class<T> type);

    <T> Optional<T> findById(Integer integer, Class<T> type);
}