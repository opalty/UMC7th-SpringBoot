package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import java.util.List;

public interface StoreMissionRepository extends JpaRepository<Mission, Long> {
    // 특정 가게의 미션 목록을 페이지네이션과 함께 조회
    List<Mission> findByStoreId(Long storeId, org.springframework.data.domain.PageRequest pageRequest);
}