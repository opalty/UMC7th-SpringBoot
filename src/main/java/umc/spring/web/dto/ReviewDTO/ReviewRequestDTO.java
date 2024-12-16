package umc.spring.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

@Getter
public class ReviewRequestDTO {

    @NotNull(message = "Store ID 는 반드시 입력해야 합니다.")
    @ExistStore(message = "해당 가게는 존재하지 않습니다.")
    private Long storeId;  // 가게 ID

    @NotNull(message = "Score 는 반드시 입력해야 합니다.")
    private Float score;   // 리뷰 점수

    @NotBlank(message = "Title 는 반드시 입력해야 합니다.")
    private String title;  // 리뷰 제목

    @NotBlank(message = "Review 내용은 반드시 입력해야 합니다.")
    private String contents;  // 리뷰 내용
}

