package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
//9주차 미션1
public interface MemberReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByStoreId(Long storeId, Pageable pageable);
}
