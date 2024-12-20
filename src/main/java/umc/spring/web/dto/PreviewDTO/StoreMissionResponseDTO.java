package umc.spring.web.dto.PreviewDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StoreMissionResponseDTO {
    private Long id;          // 미션 ID
    private Long storeId;     // 가게 ID
    private Integer reward;   // 보상
    private LocalDate deadline; // 마감일
    private String missionSpec; // 미션 설명
}