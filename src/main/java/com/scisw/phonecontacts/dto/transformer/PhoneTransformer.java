package com.scisw.phonecontacts.dto.transformer;

import com.scisw.phonecontacts.domain.Phone;
import com.scisw.phonecontacts.dto.PhoneDto;

public class PhoneTransformer {
    public static PhoneDto convertToDto(Phone phone){
        return PhoneDto.builder()
                .phoneNumber(phone.getPhoneNumber())
                .build();
    }
    public static Phone convertToEntity(PhoneDto phoneDto){
        Phone phone = new Phone();
        phone.setPhoneNumber(phoneDto.getPhoneNumber());
        return phone;
    }

}
