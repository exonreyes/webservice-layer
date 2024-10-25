package nova.presentation.controller;

import lombok.RequiredArgsConstructor;
import nova.business.facade.AreaFacade;
import nova.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("area")
@RequiredArgsConstructor
public class AreaController {

    private final AreaFacade areaFacade;

    @GetMapping
    public ResponseEntity<ApiResponse> getArea() {
        return ResponseEntity.ok(ApiResponse.
                builder().data(areaFacade.getAreas()).build());
    }

    @GetMapping("reportes")
    public ResponseEntity<ApiResponse> getReportes() {
        return ResponseEntity.ok(ApiResponse.builder().data(areaFacade.getAreasWithReportes()).build());
    }

}
