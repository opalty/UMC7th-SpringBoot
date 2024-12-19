package umc.spring.web.dto.MemberMissionDTO;

import lombok.Getter;
import umc.spring.validation.annotation.CheckPage;

public class MemberMissionRequestDTO {

    @Getter
    public static class addMissionToMemberListDto{
    }
//9주차 미션
    @Getter
    public static class ReviewPageRequestDTO {
        @CheckPage
        private Integer page;
    }
}
