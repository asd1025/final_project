package com.cafe24.shoppingmall.validator;

import com.cafe24.shoppingmall.validator.constraints.ValidID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IDValidator implements ConstraintValidator<ValidID, String> {
   // 아이디는 4~12자리의 영소대문자와 숫자만 허용
   private Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{4,12}$");
   public void initialize(ValidID constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      if(value==null||value.length()==0||"".contentEquals(value)){
      return false;
      }
      return pattern.matcher(value).matches();

   }
}
