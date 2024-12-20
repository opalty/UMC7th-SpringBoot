package umc.spring.service.TempService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// 워크북이랑 클라스 이름 다름
public class TempCommandServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
    }
}
