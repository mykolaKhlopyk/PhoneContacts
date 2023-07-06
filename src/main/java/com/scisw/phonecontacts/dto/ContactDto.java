package com.scisw.phonecontacts.dto;

import com.scisw.phonecontacts.util.annotations.UniqueContactName;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ContactDto {
    @NotBlank
    @UniqueContactName
    private String name;
    private Set<EmailDto> emails;
    private Set<PhoneDto> phones;
}
