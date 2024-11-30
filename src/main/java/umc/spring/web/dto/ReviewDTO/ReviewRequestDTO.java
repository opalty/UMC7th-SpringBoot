package umc.spring.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

@Getter
public class ReviewRequestDTO {

    @NotNull(message = "Store ID is required.")
    @ExistStore(message = "해당 가게는 존재하지 않습니다.")
    private Long storeId;  // 가게 ID

    @NotNull(message = "Score is required.")
    private Float score;   // 리뷰 점수

    @NotBlank(message = "Title is required.")
    private String title;  // 리뷰 제목

    @NotBlank(message = "Review contents is required.")
    private String contents;  // 리뷰 내용
}

