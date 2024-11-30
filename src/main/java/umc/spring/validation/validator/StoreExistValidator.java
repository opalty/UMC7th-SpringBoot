package umc.spring.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistStore;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    // StoreRepository를 생성자로 주입받음
    @Autowired
    public StoreExistValidator(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        // storeId가 유효한 가게 ID인지 체크
        return storeId != null && storeRepository.existsById(storeId);
    }
}

