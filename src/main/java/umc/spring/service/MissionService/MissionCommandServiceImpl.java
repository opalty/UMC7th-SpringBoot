package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.converter.MissionConverter;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MissionConverter missionConverter;

    @Override
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDTO.createMissionRequestDTO request) {
        // 가게 존재 여부 확인
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게는 존재하지 않습니다."));

        // 요청 DTO를 Mission 엔티티로 변환
        Mission mission = missionConverter.toMission(request);

        // 미션 저장
        mission.setStore(store);  // 미션과 가게 연결
        Mission savedMission = missionRepository.save(mission);

        return savedMission;
    }
}

