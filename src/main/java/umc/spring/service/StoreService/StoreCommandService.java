package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRequestDTO.CreateStoreDTO;
import umc.spring.domain.Store;

public interface StoreCommandService {

    Store addStore(CreateStoreDTO request);
}
