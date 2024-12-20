package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;

public class StoreRegionHandler extends GeneralException {

    public StoreRegionHandler(ErrorStatus errorCode) {
        super(errorCode); // errorCode를 전달
    }
}

