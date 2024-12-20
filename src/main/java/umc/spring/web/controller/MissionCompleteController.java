package umc.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.web.dto.MissionDTO.MissionCompleteRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionCompleteResponseDTO;
import umc.spring.service.MissionService.MissionCompleteService;

@RestController
@RequestMapping("/missions")
public class MissionCompleteController {

    private final MissionCompleteService missionCompleteService;

    @Autowired
    public MissionCompleteController(MissionCompleteService missionCompleteService) {
        this.missionCompleteService = missionCompleteService;
    }

    @PutMapping("/complete")
    public ResponseEntity<MissionCompleteResponseDTO> completeMission(@RequestBody MissionCompleteRequestDTO missionCompleteRequestDTO) {
        // 미션을 완료 상태로 변경하고, 완료된 미션에 대한 응답 정보를 받음
        MissionCompleteResponseDTO responseDTO = missionCompleteService.completeMission(missionCompleteRequestDTO);

        // 성공적으로 미션을 완료했으면, 상태 코드 200과 함께 응답 본문으로 반환
        return ResponseEntity.ok(responseDTO);
    }
}
