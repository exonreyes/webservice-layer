package nova.presentation.controller;

import lombok.RequiredArgsConstructor;
import nova.business.facade.UnidadFacade;
import nova.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unidad")
@RequiredArgsConstructor
public class UnidadController {
    private final UnidadFacade unidadFacade;

    @GetMapping
    public ResponseEntity<ApiResponse> getUnidad() {
        return ResponseEntity.ok(ApiResponse.builder().data(unidadFacade.getUnidades()).build());
    }

    @GetMapping("contacto")
    public ResponseEntity<ApiResponse> getContacto(@RequestParam("unidadId") Integer idUnidad) {
        return ResponseEntity.ok(ApiResponse.builder().data(unidadFacade.getContacto(idUnidad)).build());
    }
}
