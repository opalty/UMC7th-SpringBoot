package umc.spring.service.MissionService;

import umc.spring.web.dto.MissionDTO.MissionCompleteRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionCompleteResponseDTO;

public interface MissionCompleteService {
    MissionCompleteResponseDTO completeMission(MissionCompleteRequestDTO missionCompleteRequestDTO);
}