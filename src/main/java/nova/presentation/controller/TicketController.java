package nova.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.business.facade.TicketFacade;
import nova.common.ApiResponse;
import nova.presentation.controller.request.TicketFiltroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketFacade ticketFacade;

    @GetMapping
    public ResponseEntity<ApiResponse> getByFiltro(@Valid TicketFiltroRequest filtro) {
        return ResponseEntity.ok(ApiResponse.builder().data(ticketFacade.getByFiltro(filtro)).build());
    }

    @GetMapping("detalles/id")
    public ResponseEntity<ApiResponse> getDetallesById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(ApiResponse.builder().data(ticketFacade.getDetallesById(id)).build());
    }

    @GetMapping("detalles/folio")
    public ResponseEntity<ApiResponse> getDetallesByFolio(@RequestParam("folio") String folio) {
        return ResponseEntity.ok(ApiResponse.builder().data(ticketFacade.getDetallesByFolio(folio)).build());
    }

}
