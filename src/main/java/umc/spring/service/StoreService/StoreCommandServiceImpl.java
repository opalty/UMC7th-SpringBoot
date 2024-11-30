package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.apiPayload.exception.handler.StoreRegionHandler;  // StoreRegionHandler import
import umc.spring.apiPayload.code.status.ErrorStatus;  // ErrorStatus import 추가
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.converter.StoreConverter;
import umc.spring.web.dto.StoreRequestDTO.CreateStoreDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final StoreConverter storeConverter;

    @Override
    @Transactional
    public Store addStore(CreateStoreDTO request) {

        // 요청에 포함된 regionId를 기반으로 해당 지역을 찾음
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new StoreRegionHandler(ErrorStatus.STORE_REGION_NOT_FOUND));  // StoreRegionHandler에 ErrorStatus 넘기기

        // Store 엔티티로 변환
        Store newStore = storeConverter.toStoreEntity(request, region);

        // 새로운 Store를 저장
        return storeRepository.save(newStore);
    }
}
