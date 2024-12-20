package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.Member;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

@Component
public class ReviewConverter {

    // ReviewRequestDTO를 Review 엔티티로 변환
    public Review toReviewEntity(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .title(dto.getTitle())
                .score(dto.getScore())
                .contents(dto.getContents())  // 리뷰 내용
                .member(member)  // 로그인한 회원 정보
                .store(store)
                .build();
    }

    // Review 엔티티를 ReviewResponseDTO로 변환
    public ReviewResponseDTO toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .memberId(review.getMember().getId())  // 리뷰 작성자 ID
                .createdAt(review.getCreatedAt())
                .build();
    }
}
