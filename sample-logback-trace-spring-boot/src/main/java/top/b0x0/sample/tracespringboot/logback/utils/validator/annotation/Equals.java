package top.b0x0.sample.tracespringboot.logback.utils.validator.annotation;


import top.b0x0.sample.tracespringboot.logback.utils.validator.checkor.EqualsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义扩展校验规则 校验字符串是否等于给定值
 *
 * @author yangaoting.wb
 * @date 2020/8/13 11:00
 */
@Documented
@Constraint(validatedBy = {EqualsValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(Equals.List.class)
public @interface Equals {
    String message() default "value is not equals";

    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Equals[] value();
    }
}
