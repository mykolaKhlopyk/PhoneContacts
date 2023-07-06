package com.scisw.phonecontacts.dto.transformers;

import com.scisw.phonecontacts.domain.Email;
import com.scisw.phonecontacts.domain.Phone;
import com.scisw.phonecontacts.dto.EmailDto;

public class EmailTransformer {
    public static EmailDto convertToDto(Email email){
        return EmailDto.builder()
                .emailAddress(email.getEmailAddress())
                .build();
    }
    public static Email convertToEntity(EmailDto emailDto){
        Email email = new Email();
        email.setEmailAddress(emailDto.getEmailAddress());
        return email;
    }

}
