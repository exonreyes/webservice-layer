package nova.persistence;

import nova.domain.entity.Operatividad;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatividadRepository extends JpaRepository<Operatividad, Integer> {
    @EntityGraph(attributePaths = {"horarios.unidad"})
    List<Operatividad> findAll();
}