package nova.persistence;

import nova.domain.entity.ContactoUnidad;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactoUnidadRepository extends JpaRepository<ContactoUnidad, Integer> {
    @EntityGraph(attributePaths = {"unidad"})
    Optional<ContactoUnidad> findByUnidad_Id(Integer id);

}