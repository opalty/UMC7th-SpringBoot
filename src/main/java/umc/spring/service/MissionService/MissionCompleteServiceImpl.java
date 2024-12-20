package umc.spring.service.MissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionDTO.MissionCompleteRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionCompleteResponseDTO;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionCompleteRepository;

@Service
public class MissionCompleteServiceImpl implements MissionCompleteService {

    private final MissionCompleteRepository missionCompleteRepository;

    @Autowired
    public MissionCompleteServiceImpl(MissionCompleteRepository missionCompleteRepository) {
        this.missionCompleteRepository = missionCompleteRepository;
    }

    @Override
    @Transactional
    public MissionCompleteResponseDTO completeMission(MissionCompleteRequestDTO missionCompleteRequestDTO) {
        // MissionId와 MemberId로 MemberMission을 찾기
        MemberMission memberMission = missionCompleteRepository.findByMission_IdAndMember_Id(
                        missionCompleteRequestDTO.getMissionId(), missionCompleteRequestDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("미션 또는 멤버를 찾을 수 없습니다."));

        // 미션 상태를 '완료'로 변경
        memberMission.setStatus(MissionStatus.COMPLETE);  // 상태를 '완료'로 설정

        // 미션 상태 업데이트
        missionCompleteRepository.save(memberMission);

        // 응답 DTO 반환
        return new MissionCompleteResponseDTO(
                memberMission.getMission().getId(),
                memberMission.getMember().getId(),
                "COMPLETE",
                "미션이 성공적으로 완료되었습니다."
        );
    }
}
