package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;


@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;
    private final StoreConverter storeConverter;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> addStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDTO request) {
        // Store 엔티티 저장
        Store store = storeCommandService.addStore(request);

        // DTO로 변환 후 ApiResponse에 담아 반환
        return ApiResponse.onSuccess(storeConverter.toCreateStoreResultDTO(store));
    }
}
