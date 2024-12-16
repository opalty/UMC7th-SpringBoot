package umc.spring.apiPayload.code;

import umc.spring.apiPayload.code.ErrorReasonDTO;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
