package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.service.MemberMissionService.MemberReviewQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO.MemberReviewPageResponseDTO;


@RestController
@RequestMapping("/api/member-reviews")
public class MemberReviewController {

    @Autowired
    private MemberReviewQueryService memberReviewQueryService;

    @Operation(summary = "회원의 가게 리뷰 목록 보기", description = "모든 리뷰를 페이징하여 조회합니다.")
    @ApiResponse(responseCode = "200", description = "리뷰 목록 반환")
    @ApiResponse(responseCode = "400", description = "잘못된 페이지 번호")
    @GetMapping("/{storeId}")
    public ResponseEntity<MemberReviewPageResponseDTO> getReviewsForStore(
            @PathVariable Long storeId,
            @RequestParam(name = "page") @CheckPage Integer page) {
        return ResponseEntity.ok(memberReviewQueryService.getMemberReviews(storeId, page));
    }
}

