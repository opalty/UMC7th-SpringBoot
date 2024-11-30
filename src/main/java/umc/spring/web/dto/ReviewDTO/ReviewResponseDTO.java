package umc.spring.web.dto.ReviewDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {

    private Long memberId;
    private Long reviewId;
    private LocalDateTime createdAt;
}
