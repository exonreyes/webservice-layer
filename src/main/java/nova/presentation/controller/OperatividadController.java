package nova.presentation.controller;

import lombok.RequiredArgsConstructor;
import nova.business.facade.OperatividadFacade;
import nova.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("horario")
@RequiredArgsConstructor
public class OperatividadController {
    private final OperatividadFacade operatividadFacade;

    @GetMapping()
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(ApiResponse.builder().data(operatividadFacade.getAll()).build());
    }
}
