package umc.spring.web.dto.MissionDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionCompleteRequestDTO {

    private Long missionId;  // 미션 ID
    private Long memberId;   // 멤버 ID
}