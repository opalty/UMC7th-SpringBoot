package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import umc.spring.validation.annotation.ExistStore;

//8주차 미션, 가게에 미션 추가하기 API
@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.createMissionResponseDTO> createMission(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.createMissionRequestDTO requestDTO) {
        Mission mission = missionCommandService.createMission(storeId, requestDTO);
        return ApiResponse.onSuccess(MissionConverter.createMissionResponseDTO(mission));
    }
}