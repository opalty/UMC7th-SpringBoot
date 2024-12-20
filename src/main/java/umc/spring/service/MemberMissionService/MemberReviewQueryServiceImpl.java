package umc.spring.service.MemberMissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberReviewConverter;
import umc.spring.domain.Review;
import umc.spring.repository.MemberReviewRepository;
import umc.spring.service.MemberMissionService.MemberReviewQueryService;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO.MemberReviewPageResponseDTO;


@Service
public class MemberReviewQueryServiceImpl implements MemberReviewQueryService {

    private final MemberReviewRepository memberReviewRepository;

    public MemberReviewQueryServiceImpl(MemberReviewRepository memberReviewRepository) {
        this.memberReviewRepository = memberReviewRepository;
    }

    @Override
    public MemberReviewPageResponseDTO getMemberReviews(Long storeId, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 10); // 페이지 번호 1 기반 처리
        Page<Review> reviews = memberReviewRepository.findByStoreId(storeId, pageable);

        return MemberReviewConverter.toMemberReviewPageResponseDTO(
                storeId,
                reviews.getContent().isEmpty() ? null : reviews.getContent().get(0).getStore().getName(),
                reviews.getContent(),
                reviews.getNumber() + 1,  // 1 기반 페이지
                reviews.getTotalPages()
        );
    }
}
