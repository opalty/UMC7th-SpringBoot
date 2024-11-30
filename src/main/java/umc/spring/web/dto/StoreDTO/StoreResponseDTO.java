package umc.spring.web.dto.StoreDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateStoreResultDTO {

        private Long storeId;          // 생성된 가게 ID
        private String storeName;
        private String regionName;
        private LocalDateTime createdAt;

    }
}

