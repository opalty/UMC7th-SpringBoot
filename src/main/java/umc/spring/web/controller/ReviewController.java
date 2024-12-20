package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;


//8주차 미션, 가게에 리뷰 추가하기 api
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> addReview(@RequestBody @Valid ReviewRequestDTO request) {
        // 리뷰 추가 서비스 호출
        Review review = reviewCommandService.addReview(request);

        // DTO로 변환 후 반환 (reviewId 추가)
        ReviewResponseDTO response = new ReviewResponseDTO(review.getId(), review.getMember().getId(), review.getCreatedAt());
        return ResponseEntity.ok(ApiResponse.onSuccess(response));

    }
}
