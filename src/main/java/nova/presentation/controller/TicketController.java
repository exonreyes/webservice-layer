package nova.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nova.business.facade.TicketFacade;
import nova.common.ApiResponse;
import nova.presentation.controller.request.ActividadCreateRequest;
import nova.presentation.controller.request.TicketCreateRequest;
import nova.presentation.controller.request.TicketFiltroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketFacade ticketFacade;

    @PostMapping
    public ResponseEntity<ApiResponse> createTicket(@RequestBody @Valid TicketCreateRequest ticketCreateRequest) {
        return new ResponseEntity<>(ApiResponse.builder()
                .data(ticketFacade.addTicket(ticketCreateRequest))
                .code("E200")
                .message("Ticket registrado")
                .build(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getByFiltro(@Valid TicketFiltroRequest filtro) {
        var data=ticketFacade.getByFiltro(filtro);
        return ResponseEntity.ok(ApiResponse.builder().data(data.get("data")).page(data.get("page")).build());
    }

    @GetMapping("detalles/id")
    public ResponseEntity<ApiResponse> getDetallesById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(ApiResponse.builder().data(ticketFacade.getDetallesById(id)).build());
    }

    @GetMapping("detalles/folio")
    public ResponseEntity<ApiResponse> getDetallesByFolio(@RequestParam("folio") String folio) {
        return ResponseEntity.ok(ApiResponse.builder().data(ticketFacade.getDetallesByFolio(folio)).build());
    }

    @GetMapping("actividad")
    public ResponseEntity<ApiResponse> getSeguimientoById(@RequestParam("ticketId") Integer ticketId) {
        return ResponseEntity.ok(ApiResponse.builder().data(ticketFacade.getActividades(ticketId)).build());
    }

    @PostMapping("actividad")
    public ResponseEntity<ApiResponse> addActividad(@Valid @RequestBody ActividadCreateRequest params) {
        return new ResponseEntity<>(ApiResponse.builder()
                .data(ticketFacade.addActividad(params))
                .code("E200")
                .message("Actividad registrada").build(), HttpStatus.CREATED);
    }

}
