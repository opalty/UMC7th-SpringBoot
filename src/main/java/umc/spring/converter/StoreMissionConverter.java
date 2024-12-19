package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.web.dto.PreviewDTO.StoreMissionResponseDTO;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreMissionConverter {

    public StoreMissionResponseDTO convertToResponseDTO(Mission mission) {
        return StoreMissionResponseDTO.builder()
                .id(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public List<StoreMissionResponseDTO> convertToResponseDTOList(List<Mission> missions) {
        return missions.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }
}