package nova.business.service.impl;

import lombok.RequiredArgsConstructor;
import nova.common.EntityException;
import nova.persistence.TicketRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketFolioValidatorService {
    private final TicketRepository repository;

    public void execute(String folio) {
        if (repository.existsByFolio(folio)) {
            throw new EntityException("E1001", "No se pudo registrar, el folio " + folio + " ya fue asignado a otro ticket");
        }
    }
}
