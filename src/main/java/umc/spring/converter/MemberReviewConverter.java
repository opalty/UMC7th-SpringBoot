package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO.MemberReviewPageResponseDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO.MemberReviewResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
//9주차 멤버의 리뷰 목록 조회
public class MemberReviewConverter {

    public static MemberReviewResponseDTO toMemberReviewResponseDTO(Review review) {
        return MemberReviewResponseDTO.builder()
                .title(review.getTitle())
                .score(review.getScore())
                .contents(review.getContents())
                .storeName(review.getStore().getName())
                .build();
    }

    public static MemberReviewPageResponseDTO toMemberReviewPageResponseDTO(Long storeId, String storeName, List<Review> reviews, int currentPage, int totalPages) {
        return MemberReviewPageResponseDTO.builder()
                .storeId(storeId)
                .storeName(storeName)
                .reviews(reviews.stream()
                        .map(MemberReviewConverter::toMemberReviewResponseDTO)
                        .collect(Collectors.toList()))
                .currentPage(currentPage)
                .totalPages(totalPages)
                .build();
    }
}
