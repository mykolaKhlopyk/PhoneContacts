package com.scisw.phonecontacts.util.annotations;

import com.scisw.phonecontacts.util.annotations.impl.UniqueContactNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueContactNameValidator.class)
public @interface UniqueContactName {
    String message() default "Contact name already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
