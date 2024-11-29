package umc.spring.service.TempService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import umc.spring.apiPayload.exception.handler.TempHandler;  // TempHandler 예외 클래스
import umc.spring.apiPayload.code.status.ErrorStatus;

import org.springframework.context.annotation.Primary;

@Service
@RequiredArgsConstructor
@Primary  // 기본 빈으로 지정
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
