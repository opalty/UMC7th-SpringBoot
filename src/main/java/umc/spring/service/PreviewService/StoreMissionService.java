package umc.spring.service.PreviewService;

import umc.spring.web.dto.PreviewDTO.StoreMissionResponseDTO;

import java.util.List;

public interface StoreMissionService {
    List<StoreMissionResponseDTO> getMissionsByStore(Long storeId, int page);
}
