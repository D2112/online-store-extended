package com.epam.store.web.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CreateProductFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateProductForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateProductForm createProductForm = (CreateProductForm) target;
    }
}
