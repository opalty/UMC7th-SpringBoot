package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {

        @NotBlank(message = "Store name is required.")
        private String name;  // 가게 이름

        @NotNull(message = "Region ID is required.")
        private Long regionId; // 지역 ID (컬럼 이름에 맞춰서 regionId로 수정)

        @NotNull(message = "Score is required.")
        private Float score; // Float로 변경

        @NotBlank(message = "Address is required.")
        private String address; // 가게 주소
    }
}


