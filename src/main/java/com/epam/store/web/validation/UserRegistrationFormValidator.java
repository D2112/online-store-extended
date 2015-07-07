package com.epam.store.web.validation;

import com.epam.store.service.StoreService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserRegistrationFormValidator implements Validator {
    private StoreService storeService;

    public UserRegistrationFormValidator(StoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public boolean supports(Class clazz) {
        return UserRegistrationForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegistrationForm registrationForm = (UserRegistrationForm) target;
        if (!registrationForm.getPassword().equals(registrationForm.getPasswordConfirm())) {
            errors.rejectValue("password", "valid.passwordDifferent");
        }
        if (storeService.isEmailRegistered(registrationForm.getEmail())) {
            errors.rejectValue("email", "valid.emailAlreadyRegistered");
        }
    }

}
