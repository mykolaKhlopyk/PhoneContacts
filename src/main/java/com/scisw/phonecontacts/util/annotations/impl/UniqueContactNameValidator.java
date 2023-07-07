package com.scisw.phonecontacts.util.annotations.impl;

import com.scisw.phonecontacts.repository.ContactRepository;
import com.scisw.phonecontacts.util.annotations.UniqueContactName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@RequiredArgsConstructor
public class UniqueContactNameValidator implements ConstraintValidator<UniqueContactName, String> {

    private final ContactRepository contactRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return contactRepository.findContactByName(name).isEmpty();
    }

}
