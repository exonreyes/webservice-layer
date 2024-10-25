package nova.persistence;

import nova.domain.entity.Area;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    @EntityGraph(attributePaths = {"reportes"})
    @Query("from Area ")
    List<Area> getAreasWithReportes();

    <T> List<T> findBy(Class<T> type);

}