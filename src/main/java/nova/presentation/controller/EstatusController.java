package nova.presentation.controller;

import lombok.RequiredArgsConstructor;
import nova.business.facade.EstatusFacade;
import nova.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatus")
@RequiredArgsConstructor
public class EstatusController {
    private final EstatusFacade facade;

    @GetMapping
    public ResponseEntity<ApiResponse> getEstatus() {
        return ResponseEntity.ok(ApiResponse.builder().data(facade.getEstatus()).build());
    }
}
