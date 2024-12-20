package umc.spring.web.dto.MissionDTO;

import lombok.Getter;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class createMissionRequestDTO{
        @NotNull(message = "보상이 반드시 포함되어야 합니다.")
        private Integer reward;

        @NotNull(message = "마감 기한은 반드시 입력되어야 합니다.")
        @Future(message = "마감 기한은 현재 날짜 이후여야 합니다.")
        private LocalDate deadline;

        @NotBlank(message = "미션 내용은 반드시 입력해야 합니다.")
        private String missionSpec;
    }
}