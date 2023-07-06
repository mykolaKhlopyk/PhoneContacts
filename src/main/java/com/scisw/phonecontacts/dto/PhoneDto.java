package com.scisw.phonecontacts.dto;

import com.scisw.phonecontacts.util.annotations.ValidPhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {
    @ValidPhoneNumber
    private String phoneNumber;
}
