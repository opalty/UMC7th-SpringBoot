package umc.spring.service.MemberMissionService;

import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO.MemberReviewPageResponseDTO;

public interface MemberReviewQueryService {
    MemberReviewPageResponseDTO getMemberReviews(Long storeId, Integer page);
}
