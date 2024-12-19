package umc.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.web.dto.PreviewDTO.StoreMissionResponseDTO;
import umc.spring.service.PreviewService.StoreMissionService;
import umc.spring.validation.annotation.CheckPage;

import java.util.List;

@RestController
public class StoreMissionController {

    private final StoreMissionService storeMissionService;

    @Autowired
    public StoreMissionController(StoreMissionService storeMissionService) {
        this.storeMissionService = storeMissionService;
    }

    @GetMapping("/stores/{storeId}/missions")
    public ResponseEntity<List<StoreMissionResponseDTO>> getMissions(
            @PathVariable Long storeId,
            @CheckPage @RequestParam(name = "page", defaultValue = "1") Integer page // 기본값 설정
    ) {
        List<StoreMissionResponseDTO> missions = storeMissionService.getMissionsByStore(storeId, page);
        return ResponseEntity.ok(missions);
    }

}
