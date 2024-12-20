package umc.spring.validation.annotation;

import umc.spring.validation.validator.CheckPageValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckPageValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "Invalid page number (must be greater than 0)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
