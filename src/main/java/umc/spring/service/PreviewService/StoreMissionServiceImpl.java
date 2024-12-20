package umc.spring.service.PreviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreMissionConverter; // 변경된 컨버터 이름
import umc.spring.domain.Mission;
import umc.spring.web.dto.PreviewDTO.StoreMissionResponseDTO;
import umc.spring.repository.StoreMissionRepository;

import java.util.List;

@Service
public class StoreMissionServiceImpl implements StoreMissionService {

    private final StoreMissionRepository storeMissionRepository;
    private final StoreMissionConverter storeMissionConverter;

    @Autowired
    public StoreMissionServiceImpl(StoreMissionRepository storeMissionRepository, StoreMissionConverter storeMissionConverter) {
        this.storeMissionRepository = storeMissionRepository;
        this.storeMissionConverter = storeMissionConverter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StoreMissionResponseDTO> getMissionsByStore(Long storeId, int page) {
        int validPage = page > 0 ? page - 1 : 0; // 페이지 번호 보정
        PageRequest pageRequest = PageRequest.of(validPage, 10); // 페이지네이션 설정

        List<Mission> missions = storeMissionRepository.findByStoreId(storeId, pageRequest);

        return storeMissionConverter.convertToResponseDTOList(missions);
    }
}

