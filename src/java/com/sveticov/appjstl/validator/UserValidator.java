package com.sveticov.appjstl.validator;

import com.sveticov.appjstl.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserModel.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserModel userModel=(UserModel) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name_user_model","NotEmpty.userForm.name_user_model");

        if(userModel.getName_user_model().length()<2 || userModel.getName_user_model().length()>20){
            errors.rejectValue("name_user_model","NotEmpty.userForm.nameLength");
        }
    }
}
