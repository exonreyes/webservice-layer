package nova.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import nova.business.util.TicketFiltro;
import nova.common.PageData;
import nova.common.PageInfo;
import nova.domain.entity.Ticket;
import nova.domain.entity.query.TicketInfoQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepositoryCustomImpl implements TicketRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PageData<TicketInfoQuery> findByFiltro(TicketFiltro filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TicketInfoQuery> cq = cb.createQuery(TicketInfoQuery.class);
        Root<Ticket> ticket = cq.from(Ticket.class);

        // Unir entidades relacionadas
        Join<Object, Object> unidadJoin = ticket.join("unidad", JoinType.INNER);
        Join<Object, Object> reporteJoin = ticket.join("reporte", JoinType.INNER);
        Join<Object, Object> estatusJoin = ticket.join("estatus", JoinType.INNER);

        // Seleccionar los campos para mapear a TicketInfoDTO
        cq.select(cb.construct(
                TicketInfoQuery.class,
                ticket.get("id"),
                unidadJoin.get("clave"),
                unidadJoin.get("nombre"),  // Asegúrate que estos atributos existan en la entidad Unidad
                estatusJoin.get("id"),
                estatusJoin.get("nombre"),
                reporteJoin.get("id"),
                reporteJoin.get("nombre"), // Asegúrate que estos atributos existan en la entidad Reporte
                reporteJoin.get("area").get("id"),
                reporteJoin.get("area").get("nombre"), // Asegúrate que estos atributos existan
                ticket.get("folio"),
                ticket.get("agente"),
                ticket.get("creado")
        ));

        // Filtros dinámicos
        List<Predicate> predicates = new ArrayList<>();

        // Agregar filtros de Unidad
        if (filtro.getUnidadId() != null) {
            predicates.add(cb.equal(unidadJoin.get("id"), filtro.getUnidadId()));
        }

        // Agregar filtros de Estatus
        if (filtro.getEstatusId() != null) {
            predicates.add(cb.equal(ticket.get("estatus").get("id"), filtro.getEstatusId()));
        }

        // Agregar filtros de Área
        if (filtro.getAreaId() != null) {
            predicates.add(cb.equal(reporteJoin.get("area").get("id"), filtro.getAreaId()));
        }

        // Filtros de fecha
        if (filtro.getDesde() != null) {
            predicates.add(cb.greaterThanOrEqualTo(ticket.get("creado"), filtro.getDesde()));
        }
        if (filtro.getHasta() != null) {
            predicates.add(cb.lessThanOrEqualTo(ticket.get("creado"), filtro.getHasta()));
        }

        // Filtro de folio
        if (filtro.getFolio() != null) {
            predicates.add(cb.like(ticket.get("folio"), "%" + filtro.getFolio() + "%"));
        }

        // Aplicar los predicados
        cq.where(predicates.toArray(new Predicate[0]));

        // Ejecutar la consulta con paginación
        List<TicketInfoQuery> resultList = entityManager.createQuery(cq)
                .setFirstResult(filtro.getPage() != null ? filtro.getPage() * filtro.getSize() : 0)
                .setMaxResults(filtro.getSize() != null ? filtro.getSize() : 10)
                .getResultList();

        // Contar el total de resultados
        Long totalResults = countByFiltro(filtro);
        Page<TicketInfoQuery> page = new PageImpl<>(resultList, PageRequest.of(filtro.getPage(), filtro.getSize()), totalResults);

        // Devolver respuesta paginada
        PageData<TicketInfoQuery> dataPage = new PageData<>(page.getContent(), new PageInfo(page.getNumberOfElements(), page.getTotalElements(), page.getTotalPages()));
        return dataPage;
    }

    private Long countByFiltro(TicketFiltro filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ticket> ticket = cq.from(Ticket.class);

        // Reutilizar los predicados si son aplicables directamente a la entidad `Ticket`
        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getUnidadId() != null) {
            predicates.add(cb.equal(ticket.get("unidad").get("id"), filtro.getUnidadId()));
        }

        if (filtro.getEstatusId() != null) {
            predicates.add(cb.equal(ticket.get("estatus").get("id"), filtro.getEstatusId()));
        }

        if (filtro.getAreaId() != null) {
            predicates.add(cb.equal(ticket.get("reporte").get("area").get("id"), filtro.getAreaId()));
        }

        if (filtro.getDesde() != null && filtro.getHasta() != null) {
            predicates.add(cb.between(ticket.get("creado"), filtro.getDesde(), filtro.getHasta()));
        }

        if (filtro.getFolio() != null) {
            predicates.add(cb.like(ticket.get("folio"), "%" + filtro.getFolio() + "%"));
        }

        // Contar el número total de resultados
        cq.select(cb.count(ticket));
        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getSingleResult();
    }

}
