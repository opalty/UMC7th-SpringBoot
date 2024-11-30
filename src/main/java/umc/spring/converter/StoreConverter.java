package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.domain.Region;
import umc.spring.web.dto.StoreRequestDTO.CreateStoreDTO;
import umc.spring.web.dto.StoreResponseDTO;

import org.springframework.stereotype.Component;
@Component
public class StoreConverter {

    public Store toStoreEntity(CreateStoreDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .score(dto.getScore())  // score 추가
                .address(dto.getAddress())  // address 추가
                .region(region)
                .build();
    }
    // StoreResponseDTO 변환 메서드 추가
    public StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .regionName(store.getRegion().getName())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
