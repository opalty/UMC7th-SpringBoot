package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import umc.spring.validation.validator.StoreExistValidator;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StoreExistValidator.class) // 검증을 담당할 클래스 지정
public @interface ExistStore {

    String message() default "해당 가게는 존재하지 않습니다."; // 기본 에러 메시지

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
