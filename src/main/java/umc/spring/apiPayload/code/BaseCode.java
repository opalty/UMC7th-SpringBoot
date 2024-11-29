package umc.spring.apiPayload.code;

import umc.spring.apiPayload.code.ReasonDTO;  // ReasonDTO 임포트

public interface BaseCode {

    ReasonDTO getReason(); // ReasonDTO를 반환

    ReasonDTO getReasonHttpStatus(); // ReasonDTO를 반환
}
