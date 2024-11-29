package umc.spring.web.controller;

// 필요한 import 문
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import umc.spring.converter.TempConverter;  // TempConverter 클래스 import
import umc.spring.web.dto.TempResponse;  // TempResponse 클래스 import
import umc.spring.apiPayload.ApiResponse;  // ApiResponse 클래스 import
import umc.spring.service.TempService.TempQueryService;

//빈 지정
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    // TempQueryService를 구현한 TempCommandServiceImpl과 TempQueryServiceImpl 두 개의 빈이 존재하기 때문에 앞에 걸 빈으로 지정함
    //@Autowired
    //@Qualifier("tempQueryServiceImpl")  // tempQueryServiceImpl 빈을 주입
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    //내가 추가로 @RequestParam을 사용하는 메소드의 인자에 대해 이름을 명시적으로 지정함
    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam(name = "flag") Integer flag) {
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }

}

