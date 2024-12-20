package umc.spring.web.dto.MemberMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addMissionToMemberListResponseDTO{
        String message;
        Long memberId;
        Long missionId;
        LocalDateTime createdAt;
    }
    //9주차 미션
    @Getter
    @Builder
    public static class MemberReviewResponseDTO {
        private String title;
        private Float score;
        private String contents;
        private String storeName;
        private List<String> imageUrls;
    }

    @Getter
    @Builder
    public static class MemberReviewPageResponseDTO {
        private Long storeId;
        private String storeName;
        private List<MemberReviewResponseDTO> reviews;
        private int currentPage;
        private int totalPages;
    }
}