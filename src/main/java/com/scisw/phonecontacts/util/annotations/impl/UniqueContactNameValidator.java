package com.scisw.phonecontacts.util.annotations.impl;

import com.scisw.phonecontacts.repository.ContactRepository;
import com.scisw.phonecontacts.util.annotations.UniqueContactName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class UniqueContactNameValidator implements ConstraintValidator<UniqueContactName, String> {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return contactRepository.findContactByName(name).isEmpty();
    }

}
