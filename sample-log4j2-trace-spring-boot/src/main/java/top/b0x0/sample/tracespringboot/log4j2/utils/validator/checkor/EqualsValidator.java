package top.b0x0.sample.tracespringboot.log4j2.utils.validator.checkor;



import top.b0x0.sample.tracespringboot.log4j2.utils.validator.annotation.Equals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yangaoting.wb
 * @date 2020/8/13 11:17
 */
public class EqualsValidator implements ConstraintValidator<Equals, String> {

    private String expectValue;

    @Override
    public void initialize(Equals constraintAnnotation) {
        expectValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return expectValue.equals(value);
    }
}
