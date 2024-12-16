package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.exception.GeneralException;  // GeneralException 클래스 import
import umc.spring.apiPayload.code.BaseErrorCode;        // BaseErrorCode 인터페이스 import

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
