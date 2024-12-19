package umc.spring.web.dto.MissionDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionCompleteResponseDTO {

    private Long missionId;      // 미션 ID
    private Long memberId;       // 멤버 ID
    private String status;       // 미션 상태 (예: "COMPLETE")
    private String message;      // 추가 메시지 (예: 완료 메시지)

    public MissionCompleteResponseDTO(Long missionId, Long memberId, String status, String message) {
        this.missionId = missionId;
        this.memberId = memberId;
        this.status = status;
        this.message = message;
    }
}
