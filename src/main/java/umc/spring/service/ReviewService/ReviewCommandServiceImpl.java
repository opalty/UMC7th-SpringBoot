package umc.spring.service.ReviewService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.Member;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.apiPayload.exception.handler.StoreRegionHandler;  // 예외 처리 핸들러 임포트
import umc.spring.apiPayload.code.status.ErrorStatus;  // ErrorStatus 임포트

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;  // 하드코딩된 사용자 조회를 위한 레포지토리

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository, StoreRepository storeRepository, MemberRepository memberRepository) {
        this.reviewRepository = reviewRepository;
        this.storeRepository = storeRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO request) {
        // 요청 받은 storeId로 가게 존재 여부 확인
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreRegionHandler(ErrorStatus.STORE_NOT_FOUND));

        // 하드코딩된 사용자(데이터베이스에서 첫 번째 회원을 가져옴)
        Member member = memberRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("No member found"));

        // Review 엔티티 생성
        Review review = Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)  // 하드코딩된 사용자 사용
                .store(store)
                .build();

        // 리뷰 저장
        return reviewRepository.save(review);
    }
}


