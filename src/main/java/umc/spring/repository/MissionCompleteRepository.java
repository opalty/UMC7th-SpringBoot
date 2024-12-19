package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import umc.spring.domain.mapping.MemberMission;

public interface MissionCompleteRepository extends JpaRepository<MemberMission, Long> {
    // MissionId와 MemberId로 MemberMission을 찾는 메소드 추가
    Optional<MemberMission> findByMission_IdAndMember_Id(Long missionId, Long memberId);
}
