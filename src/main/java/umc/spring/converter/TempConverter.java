package umc.spring.converter;

// 필요한 import 문
import umc.spring.web.dto.TempResponse; // TempResponse 클래스 위치
import umc.spring.web.dto.TempResponse.TempTestDTO; // TempTestDTO 클래스 접근을 위해

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}