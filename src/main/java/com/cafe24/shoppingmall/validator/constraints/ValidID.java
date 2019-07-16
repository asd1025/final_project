package com.cafe24.shoppingmall.validator.constraints;

import com.cafe24.shoppingmall.validator.IDValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = IDValidator.class)
public @interface ValidID {
    String message() default "아이디는 4~12자리의 영문 대소문자와 숫자로만 입력 가능합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
